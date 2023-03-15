package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class CoordinatesServerModel(
    @SerializedName("lon") var lon: Double? = null,
    @SerializedName("lat") var lat: Double? = null
)
