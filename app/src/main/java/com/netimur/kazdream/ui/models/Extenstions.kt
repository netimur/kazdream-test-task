package com.netimur.kazdream.ui.models

import com.netimur.kazdream.R
import com.netimur.kazdream.data.model.currentweather.CurrentWeatherServerModel
import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel

fun CurrentWeatherServerModel.mapToUiModel(hourWeather: List<HourWeatherDataServerModel>): CityWeatherUiModel {
    val iconId = if (this.weatherServerModel[0].main!! == "Rain") {
        R.drawable.rainy
    } else {
        R.drawable.clear_day
    }
    val hourWeatherList: MutableList<HourWeatherUiModel> = ArrayList()
    val regex = "\\d{2}:\\d{2}".toRegex()

    for (i in hourWeather.indices) {
        val match = regex.find(hourWeather[i].dtTxt)!!
        hourWeatherList.add(
            HourWeatherUiModel(
                match.value ?: "12",
                hourWeather[i].main.temp.toInt()
            )
        )
    }

    return CityWeatherUiModel(
        this.name,
        iconId,
        this.mainServerModel.feelsLike!!.toInt(),
        this.mainServerModel.temp!!.toInt(),
        this.windServerModel.speed!!,
        this.mainServerModel.humidity!!.toInt(),
        this.mainServerModel.pressure!!,
        hourWeatherList.toList()
    )
}