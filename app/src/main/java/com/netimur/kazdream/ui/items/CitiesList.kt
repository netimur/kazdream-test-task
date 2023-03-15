package com.netimur.kazdream.ui.items

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.netimur.kazdream.ui.models.CityItemUiModel
import com.netimur.kazdream.ui.screens.mainscreen.CityListItemUiModel

@Composable
fun CitiesList(cities: List<CityListItemUiModel>, navHostController: NavHostController) {
    LazyColumn {
        items(cities) {
            CityListItem(city = it, navHostController = navHostController)
        }
    }
}