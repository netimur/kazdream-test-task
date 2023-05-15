package com.netimur.kazdream.data.repository.reactive.weather

import com.netimur.kazdream.data.model.currentweather.CurrentWeatherServerModel
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.flow.Flow

interface CurrentWeatherRepository {
    suspend fun getCurrentWeather(city: String): Flow<Resource<CurrentWeatherServerModel>>
}