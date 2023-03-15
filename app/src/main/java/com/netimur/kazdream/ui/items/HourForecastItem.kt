package com.netimur.kazdream.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netimur.kazdream.ui.models.HourWeatherUiModel

@Composable
fun HourWeatherItem(forecast: HourWeatherUiModel) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(0.dp, 2.dp)
    ) {
        Text(text = forecast.date, fontSize = 14.sp, fontWeight = FontWeight.Normal)
        Text(text = "${forecast.temp}°", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(0.dp, 5.dp))
    }
}