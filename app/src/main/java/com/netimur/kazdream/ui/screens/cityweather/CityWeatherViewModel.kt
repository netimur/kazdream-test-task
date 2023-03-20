package com.netimur.kazdream.ui.screens.cityweather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.netimur.kazdream.common.InternetConnection
import com.netimur.kazdream.data.datasource.remote.RetrofitWeatherRemoteDataSource
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.weather.BaseWeatherManager
import com.netimur.kazdream.data.repository.weather.CurrentWeatherRepository
import com.netimur.kazdream.data.repository.weather.HourWeatherRepository
import com.netimur.kazdream.ui.models.mapToUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CityWeatherViewModel(app: Application) : AndroidViewModel(app) {
    private val apiService = RetrofitWeatherRemoteDataSource.getService()
    private val weatherManager: BaseWeatherManager =
        BaseWeatherManager(weatherRemoteDataSource = apiService, Dispatchers.IO)
    private val currentWeatherRepository: CurrentWeatherRepository = weatherManager
    private val hourWeatherRepository: HourWeatherRepository = weatherManager
    private val internetConnection = InternetConnection(app.applicationContext)

    private val _uiState: MutableStateFlow<CityWeatherUiState> =
        MutableStateFlow(CityWeatherUiState())

    val uiState: StateFlow<CityWeatherUiState>
        get() = _uiState.asStateFlow()

    fun fetchData(city: String) {
        if(_uiState.value.resource is Resource.Success) {
            return
        }
        if (internetConnection.isAvailable()) {
            lateinit var state: CityWeatherUiState
            viewModelScope.launch() {
                val response = currentWeatherRepository.getCurrentWeather(city)
                val forecast = hourWeatherRepository.getHourWeather(city)
                if (response is Resource.Success && forecast is Resource.Success) {
                    val model = response.data!!.mapToUiModel(forecast.data!!)
                    state = CityWeatherUiState(
                        isLoading = false,
                        resource = Resource.Success(model),
                    )
                } else if (response is Resource.Error || forecast is Resource.Error) {
                    state = CityWeatherUiState(
                        isLoading = false,
                        resource = Resource.Error(
                            errorMessage = response.errorMessage ?: forecast.errorMessage ?: ""
                        )
                    )
                }
                _uiState.value = state
            }
        } else {
            _uiState.value = CityWeatherUiState(
                isLoading = false,
                Resource.Error(errorMessage = "no internet connection")
            )
        }

    }
}