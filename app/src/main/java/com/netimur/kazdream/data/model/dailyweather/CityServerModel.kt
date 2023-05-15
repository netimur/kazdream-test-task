package com.netimur.kazdream.data.model.dailyweather

import com.google.gson.annotations.SerializedName
import com.netimur.kazdream.data.model.currentweather.CoordinatesServerModel

data class CityServerModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("coord") val coordinates: CoordinatesServerModel,
    @SerializedName("country") val country: String,
    @SerializedName("population") val population: Int,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("sunset") val sunset: Int?,
    @SerializedName("sunrise") val sunrise: Int?,
    )