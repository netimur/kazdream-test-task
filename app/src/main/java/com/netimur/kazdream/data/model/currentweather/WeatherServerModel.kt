package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class WeatherServerModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("main") var main: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("icon") var icon: String? = null
)
