package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class CoordinatesServerModel(
    @SerializedName("lon") val lon: Double? = null,
    @SerializedName("lat") val lat: Double? = null
)
