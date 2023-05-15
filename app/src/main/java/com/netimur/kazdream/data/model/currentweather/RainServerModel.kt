package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class RainServerModel(@SerializedName("1h") val oneHour: Double? = null)