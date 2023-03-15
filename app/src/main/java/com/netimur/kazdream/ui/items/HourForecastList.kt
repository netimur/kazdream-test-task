package com.netimur.kazdream.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.netimur.kazdream.ui.models.HourWeatherUiModel

@Composable
fun HourForecastList(forecast: List<HourWeatherUiModel>) {
    LazyRow (horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()){
        items(forecast) {
            HourWeatherItem(forecast = it)
        }
    }
}