package com.netimur.kazdream.data.repository.reactive.weather

import com.netimur.kazdream.data.ResponseHandler
import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.currentweather.CurrentWeatherServerModel
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.standard.weather.AbstractWeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReactiveCurrentWeatherRepository(
    weatherRemoteDataSource: WeatherRemoteDataSource,
    coroutineDispatcher: CoroutineDispatcher
) : CurrentWeatherRepository,
    AbstractWeatherRepository(weatherRemoteDataSource, coroutineDispatcher) {
    override suspend fun getCurrentWeather(city: String): Flow<Resource<CurrentWeatherServerModel>> {
        return flow {
            val coordinatesResource = coordinatesRepository.getCoordinates(city)
            if (coordinatesResource is Resource.Success) {
                val response = weatherRemoteDataSource.getCurrentWeather(
                    coordinatesResource.data!!.latitude,
                    coordinatesResource.data.longitude
                )
                val resource =
                    ResponseHandler.Base<CurrentWeatherServerModel, CurrentWeatherServerModel>()
                        .handleResponse(response)
                emit(resource)
            }
        }
    }
}