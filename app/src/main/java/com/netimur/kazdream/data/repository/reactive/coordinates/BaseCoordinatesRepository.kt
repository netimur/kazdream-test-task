package com.netimur.kazdream.data.repository.reactive.coordinates

import com.netimur.kazdream.data.CoordinatesResponseHandler
import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.standard.coodinates.CoordinatesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BaseCoordinatesRepository(private val weatherRemoteDataSource: WeatherRemoteDataSource) :
    com.netimur.kazdream.data.repository.reactive.coordinates.CoordinatesRepository {
    override suspend fun getCoordinates(city: String): Flow<Resource<Coordinates>> {
        return flow {
            val response = weatherRemoteDataSource.getCoordinatesByCity(city)
            val coordinatesResource = CoordinatesResponseHandler().handleResponse(response)
            emit(coordinatesResource)
        }
    }
}