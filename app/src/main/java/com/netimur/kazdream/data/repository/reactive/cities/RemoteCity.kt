package com.netimur.kazdream.data.repository.reactive.cities

import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.data.repository.standard.weather.CurrentWeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

data class RemoteCity(
    private val city: String,
    private val currentWeatherRepository: CurrentWeatherRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    suspend fun isExists(): Boolean {
        return try {
            withContext(coroutineDispatcher) {
                val response = currentWeatherRepository.getCurrentWeather(city)
                response is Resource.Success
            }
        } catch (e: UnknownHostException) {
            false
        }
    }
}