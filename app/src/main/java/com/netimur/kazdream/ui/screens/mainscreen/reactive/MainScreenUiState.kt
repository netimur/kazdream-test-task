package com.netimur.kazdream.ui.screens.mainscreen.reactive

import com.netimur.kazdream.ui.mvi.State
import com.netimur.kazdream.ui.screens.mainscreen.CityListItemUiModel

data class MainScreenUiState(
    val isLoading: Boolean,
    val cities: List<CityListItemUiModel>,
    val inputText: String
) : State