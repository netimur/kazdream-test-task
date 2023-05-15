package com.netimur.kazdream.data.repository.standard.weather

import com.netimur.kazdream.data.model.dailyweather.DayForecastServerModel

interface WeaklyWeatherRepository {
    suspend fun getWeaklyWeather(city: String): List<DayForecastServerModel>
}