package com.yourcompany.android.landscapes.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yourcompany.android.landscapes.data.ThemeStore
import com.yourcompany.android.landscapes.data.ViewModel

@Composable
fun CompatUi(
    navController: NavHostController,
    viewModel: ViewModel = ViewModel(),
    themeStore: ThemeStore
) {
    // TODO: Define bottomBarVisibility here
    val items = listOf(Screen.List, Screen.Settings)

    Scaffold(
        // TODO: Define bottomBar here
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.List.path,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.List.path) {
                CityListUi(viewModel = viewModel,
                    onCitySelected = {
                        navController.navigate("detail/${it.name}")
                    })
            }
            composable(route = "detail/{city}") { backstackEntry ->
                val cityName =
                    backstackEntry.arguments?.getString("city") ?: error("City is required")
                val city = viewModel.cities.first { it.name == cityName }
                CityDetailUi(viewModel = viewModel, city = city, isBigLayout = false)
            }
            composable(route = Screen.Settings.path) {
                SettingsUi(themeStore = themeStore)
            }
        }
    }
}