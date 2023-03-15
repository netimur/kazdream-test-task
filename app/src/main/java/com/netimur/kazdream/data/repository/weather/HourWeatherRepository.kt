package com.netimur.kazdream.data.repository.weather

import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel
import com.netimur.kazdream.data.repository.Resource

interface HourWeatherRepository {
    suspend fun getHourWeather(city: String): Resource<List<HourWeatherDataServerModel>>
}