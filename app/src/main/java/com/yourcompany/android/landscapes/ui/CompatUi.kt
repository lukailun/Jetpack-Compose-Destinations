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
    val bottomBarVisibility = rememberSaveable { (mutableStateOf(true)) }
    val items = listOf(Screen.List, Screen.Settings)

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarVisibility.value,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
            ) {
                BottomNavigation(backgroundColor = MaterialTheme.colors.primary) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = screen.name
                                )
                            },
                            label = { Text(text = screen.name) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.path } == true,
                            onClick = {
                                navController.navigate(screen.path) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            })
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.List.path,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.List.path) {
                LaunchedEffect(null) {
                    bottomBarVisibility.value = true
                }
                CityListUi(viewModel = viewModel,
                    onCitySelected = {
                        navController.navigate("detail/${it.name}")
                    })
            }
            composable(route = "detail/{city}") { backstackEntry ->
                val cityName =
                    backstackEntry.arguments?.getString("city") ?: error("City is required")
                val city = viewModel.cities.first { it.name == cityName }
                LaunchedEffect(null) {
                    bottomBarVisibility.value = false
                }
                CityDetailUi(viewModel = viewModel, city = city, isBigLayout = false)
            }
            composable(route = Screen.Settings.path) {
                LaunchedEffect(null) {
                    bottomBarVisibility.value = true
                }
                SettingsUi(themeStore = themeStore)
            }
        }
    }
}