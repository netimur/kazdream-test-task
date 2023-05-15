package com.netimur.kazdream.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netimur.kazdream.ui.models.CityWeatherUiModel

@Composable
fun CityWeather(city: CityWeatherUiModel) {
    val regularTextSize = 20.sp

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 40.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Row(
            ) {
                Text(
                    text = city.city,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp,
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = city.iconId),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .alignByBaseline()
                )
            }
            Text(
                text = "feels like ${city.feelsLike} °",
                fontWeight = FontWeight.Light,
                fontSize = regularTextSize,

                )
            Text(
                text = "${city.temperature}°",
                fontWeight = FontWeight.Bold,
                fontSize = 80.sp,

                )
            HourForecastList(city.hourWeather)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Wind", fontSize = 14.sp, fontWeight = FontWeight.Light)
                Text(
                    text = "${city.windSpeed} mps",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Humidity", fontSize = 14.sp, fontWeight = FontWeight.Light)
                Text(text = "${city.humidity}%", fontSize = 14.sp, fontWeight = FontWeight.Light)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Press.", fontSize = 14.sp, fontWeight = FontWeight.Light)
                Text(
                    text = "${city.pressure}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}