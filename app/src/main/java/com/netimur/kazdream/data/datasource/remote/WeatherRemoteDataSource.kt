package com.netimur.kazdream.data.datasource.remote

import com.netimur.kazdream.common.Constants
import com.netimur.kazdream.data.model.coordinates.CoordinatesServerModel
import com.netimur.kazdream.data.model.currentweather.CurrentWeatherServerModel
import com.netimur.kazdream.data.model.hourweather.HourWeatherServerModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRemoteDataSource {
    @GET(Constants.COORDINATES_ENDPOINT)
    suspend fun getCoordinatesByCity(
        @Query("q") name: String,
        @Query("appid") token: String = Constants.API_TOKEN
    ): Response<List<CoordinatesServerModel>>

    @GET(Constants.CURRENT_WEATHER_ENDPOINT)
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") token: String = Constants.API_TOKEN,
        @Query("units") units: String = "metric"
    ): Response<CurrentWeatherServerModel>

    @GET(Constants.HOUR_WEATHER_ENDPOINT)
    suspend fun getHourForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") token: String = Constants.API_TOKEN,
        @Query("cnt") days: Int = 7,
        @Query("units") units: String = "metric"
    ): Response<HourWeatherServerModel>
}