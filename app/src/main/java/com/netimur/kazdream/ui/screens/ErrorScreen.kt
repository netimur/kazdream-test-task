package com.netimur.kazdream.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ErrorScreen(retryButtonClickHandler: () -> Unit, errorMessage: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = errorMessage)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = retryButtonClickHandler,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0, 136, 96))
        ) {
            Text(text = "Try again", fontWeight = FontWeight.SemiBold, color = Color.White)
        }
    }
}