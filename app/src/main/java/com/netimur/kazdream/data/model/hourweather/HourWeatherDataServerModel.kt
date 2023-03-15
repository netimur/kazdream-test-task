package com.netimur.kazdream.data.model.hourweather

import com.google.gson.annotations.SerializedName
import com.netimur.kazdream.data.model.currentweather.CloudsServerModel
import com.netimur.kazdream.data.model.currentweather.WeatherServerModel
import com.netimur.kazdream.data.model.currentweather.WindServerModel

data class HourWeatherDataServerModel(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("main")
    val main: HourMainServerModel,
    @SerializedName("weather")
    val weather: List<WeatherServerModel>,
    @SerializedName("clouds")
    val clouds: CloudsServerModel,
    @SerializedName("wind")
    val wind: WindServerModel,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: HourRainServerModel,
    @SerializedName("sys")
    val sys: HourSysServerModel,
    @SerializedName("dt_txt")
    val dtTxt: String
)
