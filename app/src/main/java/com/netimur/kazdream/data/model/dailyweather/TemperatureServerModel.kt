package com.netimur.kazdream.data.model.dailyweather

import com.google.gson.annotations.SerializedName

data class TemperatureServerModel(
    @SerializedName("day") val dayTemp :Double,
    @SerializedName("min") val minTemp:Double,
    @SerializedName("max") val maxTemp:Double,
    @SerializedName("night") val nightTemp:Double,
    @SerializedName("eve") val eveTemp:Double,
    @SerializedName("morn") val mornTemp:Double,
)