package com.netimur.kazdream.ui.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenHeader(text: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = text, fontSize = 36.sp, fontWeight = FontWeight.Bold)

    }
}