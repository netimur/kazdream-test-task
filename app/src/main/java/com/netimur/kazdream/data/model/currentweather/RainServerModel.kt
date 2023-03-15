package com.netimur.kazdream.data.model.currentweather

import com.google.gson.annotations.SerializedName

data class RainServerModel(@SerializedName("1h") var oneHour: Double? = null)