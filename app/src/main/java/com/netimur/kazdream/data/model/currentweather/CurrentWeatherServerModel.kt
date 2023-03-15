package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class CurrentWeatherServerModel(
    @SerializedName("coord") var coordinatesServerModel: CoordinatesServerModel = CoordinatesServerModel(),
    @SerializedName("weather") var weatherServerModel: ArrayList<WeatherServerModel> = arrayListOf(),
    @SerializedName("base") var base: String,
    @SerializedName("main") var mainServerModel: MainServerModel = MainServerModel(),
    @SerializedName("visibility") var visibility: Int,
    @SerializedName("wind") var windServerModel: WindServerModel = WindServerModel(),
    @SerializedName("rain") var rainServerModel: RainServerModel = RainServerModel(),
    @SerializedName("clouds") var cloudsServerModel: CloudsServerModel = CloudsServerModel(),
    @SerializedName("dt") var dt: Int,
    @SerializedName("sys") var sysServerModel: SysServerModel = SysServerModel(),
    @SerializedName("timezone") var timezone: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("cod") var cod: Int
)