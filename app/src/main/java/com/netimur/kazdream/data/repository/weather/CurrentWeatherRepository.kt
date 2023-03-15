package com.netimur.kazdream.data.repository.weather

import com.netimur.kazdream.data.model.currentweather.CurrentWeatherServerModel
import com.netimur.kazdream.data.repository.Resource

interface CurrentWeatherRepository {
    suspend fun getCurrentWeather(city: String): Resource<CurrentWeatherServerModel>
}