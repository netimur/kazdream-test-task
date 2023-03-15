package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class WindServerModel(
    @SerializedName("speed") var speed: Double? = null,
    @SerializedName("deg") var deg: Int? = null,
    @SerializedName("gust") var gust: Double? = null
)
