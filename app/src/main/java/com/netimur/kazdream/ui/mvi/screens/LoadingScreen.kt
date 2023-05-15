package com.netimur.kazdream.ui.mvi.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.netimur.kazdream.ui.items.LoadingBar

class LoadingScreen : ScreenContent {

    @Composable
    override fun Render() {
        LoadingBar()
    }

}