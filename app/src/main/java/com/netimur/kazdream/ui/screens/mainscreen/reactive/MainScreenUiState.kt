package com.netimur.kazdream.ui.screens.mainscreen.reactive

import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.ui.mvi.State
import com.netimur.kazdream.ui.screens.mainscreen.CityListItemUiModel

data class MainScreenUiState(
    val isLoading: Boolean,
    val resource: List<Resource<CityListItemUiModel>>,
    val inputText: String
) : State