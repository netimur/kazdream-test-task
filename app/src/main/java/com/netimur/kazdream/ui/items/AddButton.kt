package com.netimur.kazdream.ui.items

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.netimur.kazdream.R

@Composable
fun AddButton(onClick: () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp)) {
        Button(onClick = onClick) {
            Text(text = "Add city")
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }

}