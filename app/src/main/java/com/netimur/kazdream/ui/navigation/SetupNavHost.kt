package com.netimur.kazdream.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.netimur.kazdream.ui.screens.cityweather.CityWeatherScreen
import com.netimur.kazdream.ui.screens.mainscreen.MainScreen

sealed class Screens(val route: String) {
    object MainScreen : Screens(route = "main_screen")
    object DetailsScreen : Screens(route = "details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) {
            MainScreen(navHostController = navController)
        }

        composable(
            route = Screens.DetailsScreen.route + "/{city}",
            arguments = listOf(
                navArgument("city") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            CityWeatherScreen(city = entry.arguments!!.getString("city")!!)
        }
    }
}