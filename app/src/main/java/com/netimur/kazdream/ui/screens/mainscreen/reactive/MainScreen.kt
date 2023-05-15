package com.netimur.kazdream.ui.screens.mainscreen.reactive

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.netimur.kazdream.ui.mvi.screens.MainScreenScreenContentProducer
import com.netimur.kazdream.ui.navigation.Screens
import com.netimur.kazdream.ui.screens.mainscreen.CityListItemUiModel

@Preview
@Composable
fun MainScreen(navHostController: NavHostController = NavHostController(LocalContext.current)) {

    MainScreenContent(
        state = MainScreenUiState(false, listOf(CityListItemUiModel("Karaganda", 20)), ""),
    )
}

@Composable
fun MainScreenContent(
    state: MainScreenUiState,
) {
    MainScreenScreenContentProducer().produceScreen(state).Render()
    /*    if (state.isLoading) {
            LoadingBar()
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CitiesList(cities = state.cities, navHostController = navHostController)
                OutlinedTextField(value = state.inputText, onValueChange = {
                    val event = MainScreenEvent.Input(it)
                    inputHandler(event)
                })
                Button(onClick = {
                    val event = MainScreenEvent.AddCityButtonClicked(state.inputText)
                    addButton(event)
                }) {
                    Text(text = "Add city")
                }
            }

        }*/
}

@Composable
fun CitiesList(cities: List<CityListItemUiModel>, navHostController: NavHostController) {
    LazyColumn {
        items(cities) {
            CityItem(
                city = it
            ) { navHostController.navigate(Screens.DetailsScreen.withArgs(it.city)) }
        }
    }
}

@Composable
fun CityItem(city: CityListItemUiModel, onItemTouch: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable {
                onItemTouch()
            }
    ) {
        Row() {
            Text(text = city.city)
            Text(text = "${city.temp}")
        }
    }
}