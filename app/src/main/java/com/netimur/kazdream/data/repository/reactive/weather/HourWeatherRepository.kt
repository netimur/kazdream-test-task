package com.netimur.kazdream.data.repository.reactive.weather

import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel
import com.netimur.kazdream.data.repository.Resource
import kotlinx.coroutines.flow.Flow

interface HourWeatherRepository {
    suspend fun getHourWeather(city: String): Flow<Resource<List<HourWeatherDataServerModel>>>

}