package com.netimur.kazdream.ui.screens.cityweather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.ui.items.CityWeather
import com.netimur.kazdream.ui.items.LoadingBar
import com.netimur.kazdream.ui.screens.ErrorScreen

@Composable
fun CityWeatherScreen(city: String, cityWeatherViewModel: CityWeatherViewModel = viewModel()) {
    val cityWeatherUiState by cityWeatherViewModel.uiState.collectAsState()
    CityWeatherContent(
        cityWeatherUiState = cityWeatherUiState
    ) { cityWeatherViewModel.fetchData(city) }
    cityWeatherViewModel.fetchData(city)
}

@Composable
fun CityWeatherContent(cityWeatherUiState: CityWeatherUiState, function: () -> Unit) {
    if (cityWeatherUiState.isLoading) {
        LoadingBar()
    } else if (cityWeatherUiState.resource is Resource.Error) {
        ErrorScreen(
            retryButtonClickHandler = { function.invoke() },
            errorMessage = cityWeatherUiState.resource.errorMessage!!
        )
    } else if(cityWeatherUiState.resource is Resource.Success) {
        CityWeather(cityWeatherUiState.resource.data!!)
    }
}