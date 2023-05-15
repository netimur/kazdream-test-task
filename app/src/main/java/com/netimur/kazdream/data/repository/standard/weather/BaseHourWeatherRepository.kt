package com.netimur.kazdream.data.repository.standard.weather

import com.netimur.kazdream.data.HourWeatherResponseHandler
import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.IOException

class BaseHourWeatherRepository(
    weatherRemoteDataSource: WeatherRemoteDataSource,
    coroutineDispatcher: CoroutineDispatcher
) : AbstractWeatherRepository(weatherRemoteDataSource, coroutineDispatcher), HourWeatherRepository {

    override suspend fun getHourWeather(city: String): Resource<List<HourWeatherDataServerModel>> {
        lateinit var resource: Resource<List<HourWeatherDataServerModel>>

        return try {
            withContext(coroutineDispatcher) {
                val coordinatesResource = coordinatesRepository.getCoordinates(city)
                if (coordinatesResource is Resource.Error) {
                    resource = Resource.Error(errorMessage = "No such city")
                } else if (coordinatesResource is Resource.Success) {
                    val response = weatherRemoteDataSource.getHourForecast(
                        coordinatesResource.data!!.latitude,
                        coordinatesResource.data.longitude
                    )
                    resource = HourWeatherResponseHandler().handleResponse(response)
                }
                resource
            }
        } catch (e: IOException) {
            Resource.Error(errorMessage = e.toString())
        }
    }
}