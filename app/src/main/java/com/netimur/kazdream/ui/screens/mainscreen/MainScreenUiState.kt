package com.netimur.kazdream.ui.screens.mainscreen

import com.netimur.kazdream.data.repository.Resource

data class MainScreenUiState(
    var isLoading: Boolean = true,
    var resource: Resource<List<CityListItemUiModel>>? = null
)
