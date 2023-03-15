package com.netimur.kazdream.data.model.coordinates

import com.google.gson.annotations.SerializedName

data class CoordinatesServerModel(
    @SerializedName("name") val name: String,
    @SerializedName("local_names") val localNames: LocalNamesServerModel,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude:Double,
    @SerializedName("country") val country:String,
    @SerializedName("state") val state:String
)