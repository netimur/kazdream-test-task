package com.netimur.kazdream.data.repository.cities

interface EmbeddedCitiesRepository {
    suspend fun getSavedCities(): List<String>
    suspend fun addCity(city: String)
}