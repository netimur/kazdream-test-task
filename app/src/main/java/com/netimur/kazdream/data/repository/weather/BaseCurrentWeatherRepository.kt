package com.netimur.kazdream.data.repository.weather

import com.netimur.kazdream.data.ResponseHandler
import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.currentweather.CurrentWeatherServerModel
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.IOException

class BaseCurrentWeatherRepository(
    weatherRemoteDatasource: WeatherRemoteDataSource,
    coroutineDispatcher: CoroutineDispatcher
) :
    AbstractWeatherRepository(weatherRemoteDatasource, coroutineDispatcher),
    CurrentWeatherRepository {


    override suspend fun getCurrentWeather(city: String): Resource<CurrentWeatherServerModel> {
        lateinit var resource: Resource<CurrentWeatherServerModel>
        return try {
            withContext(coroutineDispatcher) {
                val coordinatesResource = coordinatesRepository.getCoordinates(city)
                if (coordinatesResource is Resource.Error) {
                    resource = Resource.Error(errorMessage = "No such city")
                } else if (coordinatesResource is Resource.Success) {
                    val response = weatherRemoteDataSource.getCurrentWeather(
                        coordinatesResource.data!!.latitude,
                        coordinatesResource.data.longitude
                    )
                    resource =
                        ResponseHandler.Base<CurrentWeatherServerModel, CurrentWeatherServerModel>()
                            .handleResponse(response)
                }
                resource
            }
        } catch (e: IOException) {
            Resource.Error(errorMessage = e.toString())
        }
    }
}