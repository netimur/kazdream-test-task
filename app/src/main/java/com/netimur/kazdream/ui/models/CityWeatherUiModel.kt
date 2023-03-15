package com.netimur.kazdream.ui.models

data class CityWeatherUiModel(
    val city: String,
    val iconId: Int,
    val feelsLike: Int,
    val temperature: Int,
    val windSpeed: Double,
    val humidity: Int,
    val pressure: Int,
    val hourWeather: List<HourWeatherUiModel>
) {
}