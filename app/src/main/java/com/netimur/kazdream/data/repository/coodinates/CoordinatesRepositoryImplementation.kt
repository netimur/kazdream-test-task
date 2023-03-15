package com.netimur.kazdream.data.repository.coodinates

import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.repository.Resource
import java.net.UnknownHostException

class CoordinatesRepositoryImplementation(private val weatherRemoteDataSource: WeatherRemoteDataSource) :
    CoordinatesRepository {
    override suspend fun getCoordinates(city: String): Resource<Coordinates> {
        val response = weatherRemoteDataSource.getCoordinatesByCity(city)
        return try {
            return if (response.isSuccessful) {
                val responseBody = response.body()!!
                if (responseBody.isEmpty()) {
                    Resource.Error(errorMessage = "Coordinates error")
                } else {
                    Resource.Success(
                        Coordinates(
                            responseBody[0].longitude,
                            responseBody[0].latitude
                        )
                    )
                }
            } else {
                Resource.Error(errorMessage = "Coordinates error")
            }
        } catch (e: UnknownHostException) {
            Resource.Error(errorMessage = e.message.toString())
        }

    }

}

