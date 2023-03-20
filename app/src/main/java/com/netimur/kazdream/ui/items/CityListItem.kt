package com.netimur.kazdream.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.netimur.kazdream.R
import com.netimur.kazdream.ui.navigation.Screens
import com.netimur.kazdream.ui.screens.mainscreen.CityListItemUiModel

@Composable
fun CityListItem(city: CityListItemUiModel, navHostController: NavHostController) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(true) {
                navHostController.navigate(Screens.DetailsScreen.withArgs(city.city))
            }.padding(0.dp, 10.dp)
    ) {
        Text(
            text = city.city,
            modifier = Modifier.padding(20.dp, 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Row(modifier = Modifier.padding(20.dp, 8.dp), verticalAlignment = Alignment.Bottom) {
            Image(painter = painterResource(id = R.drawable.thermostat), contentDescription = "", Modifier.size(20.dp))
            if (city.temp != null) {
                Text(text = "${city.temp} °С", fontSize = 16.sp, fontWeight = FontWeight.Light)
            }
        }

    }

}
