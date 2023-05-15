package com.netimur.kazdream.data.repository.reactive.coordinates

import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.flow.Flow

interface CoordinatesRepository {
    suspend fun getCoordinates(city: String): Flow<Resource<Coordinates>>
}