package com.netimur.kazdream.ui.screens.mainscreen.reactive

import androidx.lifecycle.ViewModel
import com.netimur.kazdream.ui.mvi.EventHandler
import com.netimur.kazdream.ui.screens.mainscreen.standard.MainScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel(), EventHandler<MainScreenEvent> {
    private var _uiState: MutableStateFlow<com.netimur.kazdream.ui.screens.mainscreen.reactive.MainScreenUiState> =
        MutableStateFlow(MainScreenUiState(true, emptyList(), ""))

    val uiState: StateFlow<com.netimur.kazdream.ui.screens.mainscreen.reactive.MainScreenUiState>
        get() = _uiState



    override fun handleEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.AddCityButtonClicked -> {

            }
            is MainScreenEvent.CityCardClicked -> {

            }
            is MainScreenEvent.Input -> {
                val input = event.input
                _uiState.value = _uiState.value.copy(isLoading = false, inputText = input)
            }
        }
    }
}