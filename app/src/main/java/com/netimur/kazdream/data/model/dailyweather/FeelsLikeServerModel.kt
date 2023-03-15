package com.netimur.kazdream.data.model.dailyweather

import com.google.gson.annotations.SerializedName

data class FeelsLikeServerModel(
    @SerializedName("day") val day: Double,
    @SerializedName("night") val night: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("morn") val morn: Double,
    )