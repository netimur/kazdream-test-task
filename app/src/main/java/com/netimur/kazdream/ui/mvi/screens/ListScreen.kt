package com.netimur.kazdream.ui.mvi.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.netimur.kazdream.ui.screens.mainscreen.reactive.CityItem
import com.netimur.kazdream.ui.screens.mainscreen.reactive.MainScreenUiState

class ListScreen(private val state: MainScreenUiState) : ScreenContent {

    @Composable
    override fun Render() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(state.cities) {
                    CityItem(city = it) {
                    }
                }
            }
            OutlinedTextField(value = "", onValueChange = { it })
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Добавить город")
            }
        }
    }
}