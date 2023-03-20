package com.netimur.kazdream.ui.screens.mainscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.netimur.kazdream.common.InternetConnection
import com.netimur.kazdream.data.datasource.local.AppDatabase
import com.netimur.kazdream.data.datasource.remote.RetrofitWeatherRemoteDataSource
import com.netimur.kazdream.data.repository.cities.EmbeddedCitiesRepository
import com.netimur.kazdream.data.repository.cities.EmbeddedCitiesRepositoryImplementation
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.weather.BaseWeatherManager
import com.netimur.kazdream.data.repository.weather.CurrentWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val db = AppDatabase.getDatabase(app.applicationContext)
    private val internetConnection = InternetConnection(app.applicationContext)
    private val weatherManager =
        BaseWeatherManager(RetrofitWeatherRemoteDataSource.getService(), Dispatchers.IO)
    private val embeddedCitiesRepository: EmbeddedCitiesRepository =
        EmbeddedCitiesRepositoryImplementation(
            db.getEmbeddedCityDao(),
            weatherManager,
            Dispatchers.IO
        )

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState>
        get() = _uiState.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        if (internetConnection.isAvailable()) {
            _uiState.value = MainScreenUiState(isLoading = true)
            viewModelScope.launch {
                val list = embeddedCitiesRepository.getSavedCities()
                _uiState.value = MainScreenUiState(isLoading = true)
                val resultList: MutableList<CityListItemUiModel> = ArrayList()
                for (item in list) {
                    val response =
                        (weatherManager as CurrentWeatherRepository).getCurrentWeather(item)
                    if (response is Resource.Success) {
                        resultList.add(
                            CityListItemUiModel(
                                item,
                                response.data!!.mainServerModel.temp!!.toInt()
                            )
                        )
                    } else {
                        resultList.add(
                            CityListItemUiModel(
                                item, null
                            )
                        )
                    }
                }
                val state = MainScreenUiState(false, Resource.Success(resultList.toList()))
                _uiState.value = state
            }
        } else {
            _uiState.value = MainScreenUiState(
                isLoading = false,
                resource = Resource.Error(errorMessage = "Internet connection lost")
            )
        }
    }

    fun addCity(city: String) {
        viewModelScope.launch {
            embeddedCitiesRepository.addCity(city)
            fetchData()
        }
    }

    private fun addCityToList(city: String) {
        viewModelScope.launch {
            weatherManager.getCurrentWeather(city)
        }
    }
}