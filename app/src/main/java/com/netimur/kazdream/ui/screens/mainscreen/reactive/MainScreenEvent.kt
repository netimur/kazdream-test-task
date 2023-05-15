package com.netimur.kazdream.ui.screens.mainscreen.reactive

sealed class MainScreenEvent {
    data class Input(val input: String) : MainScreenEvent()
    data class AddCityButtonClicked(val city: String) : MainScreenEvent()
    data class CityCardClicked(val city: String) : MainScreenEvent()
}
