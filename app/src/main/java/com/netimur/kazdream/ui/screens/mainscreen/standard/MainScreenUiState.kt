package com.netimur.kazdream.ui.screens.mainscreen.standard

import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.ui.screens.mainscreen.CityListItemUiModel

data class MainScreenUiState(
    var isLoading: Boolean = true,
    var resource: Resource<List<CityListItemUiModel>>? = null,

    )
