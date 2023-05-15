package com.netimur.kazdream.ui.mvi.screens

import com.netimur.kazdream.ui.screens.mainscreen.reactive.MainScreenUiState

class MainScreenScreenContentProducer : ScreenContentProducer<MainScreenUiState> {

    override fun produceScreen(state: MainScreenUiState): ScreenContent {
        val screenContent: ScreenContent = if (state.isLoading) {
            LoadingScreen()
        } else if (state.cities.isEmpty()) {
            EmptyListScreen()
        } else {
            ListScreen(state)
        }
        return screenContent
    }

}