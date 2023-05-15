package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class CurrentWeatherServerModel(
    @SerializedName("coord") val coordinatesServerModel: CoordinatesServerModel = CoordinatesServerModel(),
    @SerializedName("weather") val weatherServerModel: ArrayList<WeatherServerModel> = arrayListOf(),
    @SerializedName("base") val base: String,
    @SerializedName("main") val mainServerModel: MainServerModel = MainServerModel(),
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind") val windServerModel: WindServerModel = WindServerModel(),
    @SerializedName("rain") val rainServerModel: RainServerModel = RainServerModel(),
    @SerializedName("clouds") val cloudsServerModel: CloudsServerModel = CloudsServerModel(),
    @SerializedName("dt") val dt: Int,
    @SerializedName("sys") val sysServerModel: SysServerModel = SysServerModel(),
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Int
)