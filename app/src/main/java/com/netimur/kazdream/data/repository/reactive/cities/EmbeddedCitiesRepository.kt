package com.netimur.kazdream.data.repository.reactive.cities

import kotlinx.coroutines.flow.Flow

interface EmbeddedCitiesRepository {
    suspend fun getSavedCities(): Flow<List<String>>
    suspend fun addCity(city: String)
}