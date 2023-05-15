package com.netimur.kazdream.data.repository.standard.coodinates

import com.netimur.kazdream.data.CoordinatesResponseHandler
import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class BaseCoordinatesRepository(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val coroutineDispatcher: CoroutineDispatcher
) : CoordinatesRepository {

    override suspend fun getCoordinates(city: String): Resource<Coordinates> {
        return try {
            withContext(coroutineDispatcher) {
                val response = weatherRemoteDataSource.getCoordinatesByCity(city)
                CoordinatesResponseHandler().handleResponse(response)
            }
        } catch (e: UnknownHostException) {
            Resource.Error(errorMessage = e.message.toString())
        }
    }
}