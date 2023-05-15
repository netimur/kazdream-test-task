package com.netimur.kazdream.data.repository.reactive.cities

import com.netimur.kazdream.data.datasource.reactive.SavedCityDao
import com.netimur.kazdream.data.model.embeddedcity.EmbeddedCity
import com.netimur.kazdream.data.repository.standard.weather.CurrentWeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class ReactiveEmbeddedCitiesRepository(
    private val savedCityDao: SavedCityDao,
    private val currentWeatherRepository: CurrentWeatherRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : EmbeddedCitiesRepository {

    override suspend fun getSavedCities(): Flow<List<String>> {
        return flow {
            savedCityDao.getCities().onEach {
                emit(it)
            }
        }
    }

    override suspend fun addCity(city: String) {
        val remoteCity = RemoteCity(city, currentWeatherRepository, coroutineDispatcher)
        withContext(coroutineDispatcher) {
            if (remoteCity.isExists()) {
                savedCityDao.addCity(EmbeddedCity(city))
            }
        }
    }
}