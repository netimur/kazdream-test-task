package com.netimur.kazdream.ui.mvi.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class EmptyListScreen : ScreenContent {

    @Composable
    override fun Render() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Список пуст. Добавьте города.")
            OutlinedTextField(value = "", onValueChange = { it })
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Добавить город")
            }
        }
    }
}