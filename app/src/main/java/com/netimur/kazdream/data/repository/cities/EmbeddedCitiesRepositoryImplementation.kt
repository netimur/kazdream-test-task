package com.netimur.kazdream.data.repository.cities

import com.netimur.kazdream.data.datasource.local.EmbeddedCityDao
import com.netimur.kazdream.data.model.embeddedcity.EmbeddedCity
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.weather.CurrentWeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class EmbeddedCitiesRepositoryImplementation(
    private val embeddedCityDao: EmbeddedCityDao,
    private val currentWeatherRepository: CurrentWeatherRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) :
    EmbeddedCitiesRepository {
    override suspend fun getSavedCities(): List<String> {
        return withContext(coroutineDispatcher) {
            val list: MutableList<String> = ArrayList()
            val cities = embeddedCityDao.getCities()
            for (city in cities) {
                list.add(city.name)
            }
            list.toList()
        }
    }

    override suspend fun addCity(city: String) {
        try {
            withContext(coroutineDispatcher) {
                val response = currentWeatherRepository.getCurrentWeather(city)
                if (response is Resource.Success) {
                    embeddedCityDao.addCity(EmbeddedCity(response.data!!.name))
                }
            }
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        }

    }
}