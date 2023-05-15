package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class WindServerModel(
    @SerializedName("speed") val speed: Double? = null,
    @SerializedName("deg") val deg: Int? = null,
    @SerializedName("gust") val gust: Double? = null
)
