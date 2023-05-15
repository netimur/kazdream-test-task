package com.netimur.kazdream.ui.screens.mainscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.netimur.kazdream.R
import com.netimur.kazdream.data.repository.Resource
import com.netimur.kazdream.ui.items.AddButton
import com.netimur.kazdream.ui.items.CitiesList
import com.netimur.kazdream.ui.items.LoadingBar
import com.netimur.kazdream.ui.items.ScreenHeader
import com.netimur.kazdream.ui.screens.ErrorScreen
import com.netimur.kazdream.ui.screens.mainscreen.standard.MainScreenUiState
import com.netimur.kazdream.ui.screens.mainscreen.standard.MainViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel(), navHostController: NavHostController) {
    val state by mainViewModel.uiState.collectAsState()
    MainScreenContent(state = state, navHostController = navHostController, mainViewModel)
}

@Composable
fun MainScreenContent(
    state: MainScreenUiState,
    navHostController: NavHostController,
    mainViewModel: MainViewModel
) {
    if (state.isLoading) {
        LoadingBar()
    } else if (state.resource is Resource.Success) {
        MainScreenData(
            cities = state.resource!!.data!!,
            navHostController = navHostController,
            mainViewModel
        )
    } else if (state.resource is Resource.Error) {
        ErrorScreen(
            retryButtonClickHandler = { mainViewModel.fetchData() },
            errorMessage = state.resource!!.errorMessage.toString()
        )
    }
}

@Composable
fun MainScreenData(
    cities: List<CityListItemUiModel>,
    navHostController: NavHostController,
    mainViewModel: MainViewModel
) {
    val textFieldText = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column() {
            ScreenHeader(text = stringResource(R.string.weather_forecast_header))
            CitiesList(cities = cities, navHostController)
        }
        Column() {
            OutlinedTextField(
                value = textFieldText.value,
                onValueChange = { text -> textFieldText.value = text },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp),
                label = { Text(text = stringResource(R.string.add_city)) },
                placeholder = { Text(text = stringResource(R.string.enter_city_name)) }
            )
            AddButton {
                mainViewModel.addCity(textFieldText.value)
                textFieldText.value = ""
            }
        }


    }
}

