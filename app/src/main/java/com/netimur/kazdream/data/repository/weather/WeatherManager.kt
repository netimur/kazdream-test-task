package com.netimur.kazdream.data.repository.weather

import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.repository.coodinates.CoordinatesRepository
import com.netimur.kazdream.data.repository.coodinates.CoordinatesRepositoryImplementation
import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.model.currentweather.*
import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.IOError
import java.io.IOException

class WeatherManager(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val coroutineDispatcher: CoroutineDispatcher
) : CurrentWeatherRepository, HourWeatherRepository {

    private val coordinatesRepository: CoordinatesRepository =
        CoordinatesRepositoryImplementation(weatherRemoteDataSource)

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
                    resource = if (response.isSuccessful) {
                        if (response.body() == null) {
                            Resource.Error(errorMessage = "No such city")
                        } else {
                            Resource.Success(data = response.body())
                        }
                    } else {
                        Resource.Error(errorMessage = response.errorBody().toString())
                    }
                }
                resource
            }
        } catch (e: IOException) {
            Resource.Error(errorMessage = e.toString())
        }
    }

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
                    resource = if (response.isSuccessful) {
                        if (response.body() == null) {
                            Resource.Error(errorMessage = "No such city")
                        } else {
                            Resource.Success(response.body()!!.list)
                        }
                    } else {
                        Resource.Error(errorMessage = response.errorBody().toString())
                    }
                }
                resource
            }
        } catch (e: IOException) {
            Resource.Error(errorMessage = e.toString())
        }
    }

}
