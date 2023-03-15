package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class SysServerModel(
    @SerializedName("type") var type: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("sunrise") var sunrise: Int? = null,
    @SerializedName("sunset") var sunset: Int? = null
)
