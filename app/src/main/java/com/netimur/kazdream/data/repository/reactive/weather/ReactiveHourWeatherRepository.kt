package com.netimur.kazdream.data.repository.reactive.weather

import com.netimur.kazdream.data.HourWeatherResponseHandler
import com.netimur.kazdream.data.ResponseHandler
import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.standard.weather.AbstractWeatherRepository
import com.netimur.kazdream.data.repository.standard.weather.HourWeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReactiveHourWeatherRepository(
    weatherRemoteDataSource: WeatherRemoteDataSource,
    coroutineDispatcher: CoroutineDispatcher
) :
    com.netimur.kazdream.data.repository.reactive.weather.HourWeatherRepository,
    AbstractWeatherRepository(weatherRemoteDataSource, coroutineDispatcher) {
    override suspend fun getHourWeather(city: String): Flow<Resource<List<HourWeatherDataServerModel>>> {
        return flow {
            val response = coordinatesRepository.getCoordinates(city)
            if (response is Resource.Success<*>) {
                val response = weatherRemoteDataSource.getHourForecast(
                    response.data!!.latitude,
                    response.data.longitude
                )
                val resource = HourWeatherResponseHandler().handleResponse(response)
                emit(resource)
            }
        }
    }
}