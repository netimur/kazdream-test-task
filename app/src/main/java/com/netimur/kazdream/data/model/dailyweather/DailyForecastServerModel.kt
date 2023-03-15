package com.netimur.kazdream.data.model.dailyweather

import com.google.gson.annotations.SerializedName

data class DailyForecastServerModel (
    @SerializedName("city")
    val city: CityServerModel,
    @SerializedName("cod")
    val code:String,
    @SerializedName("message")
    val message:Double,
    @SerializedName("cnt")
    val daysCount: Int,
    @SerializedName("list")
    val forecast:List<DayForecastServerModel>)
