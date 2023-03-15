package com.netimur.kazdream.data.model.dailyweather

import com.google.gson.annotations.SerializedName
import com.netimur.kazdream.data.model.currentweather.WeatherServerModel

data class DayForecastServerModel(
    @SerializedName("dt") val dt: Long,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    @SerializedName("temp") val temperatures: TemperatureServerModel,
    @SerializedName("feels_like") val feelsLike: FeelsLikeServerModel,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("weather") val weather: WeatherServerModel,
    @SerializedName("speed") val speed: Double,
    @SerializedName("deg") val deg: Int,
    @SerializedName("gust") val gust: Double,
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("pop") val pop: Double,
    @SerializedName("rain") val rain: Double
)
