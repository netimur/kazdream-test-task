package com.netimur.kazdream.data.repository.standard.coodinates

import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.repository.Resource

interface CoordinatesRepository {
    suspend fun getCoordinates(city: String): Resource<Coordinates>
}