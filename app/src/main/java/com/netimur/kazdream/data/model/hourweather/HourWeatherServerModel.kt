package com.netimur.kazdream.data.model.hourweather

import com.google.gson.annotations.SerializedName
import com.netimur.kazdream.data.model.dailyweather.CityServerModel

data class HourWeatherServerModel (
    @SerializedName("cod")
    val cod:String,
    @SerializedName("message")
    val message:Int,
    @SerializedName("cnt")
    val cnt:Int,
    @SerializedName("list")
    val list:List<HourWeatherDataServerModel>,
    @SerializedName("city")
    val city:CityServerModel
)