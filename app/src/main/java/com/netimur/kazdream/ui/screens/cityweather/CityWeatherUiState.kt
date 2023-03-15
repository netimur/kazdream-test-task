package com.netimur.kazdream.ui.screens.cityweather

import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.ui.models.CityWeatherUiModel

data class CityWeatherUiState(
    var isLoading: Boolean = true,
    val resource: Resource<CityWeatherUiModel>? = null
)

