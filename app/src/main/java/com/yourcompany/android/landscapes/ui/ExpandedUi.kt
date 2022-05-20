package com.yourcompany.android.landscapes.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yourcompany.android.landscapes.R
import com.yourcompany.android.landscapes.data.ThemeStore
import com.yourcompany.android.landscapes.data.ViewModel

@Composable
fun ExpandedUi(
    navController: NavHostController,
    viewModel: ViewModel = ViewModel(),
    themeStore: ThemeStore
) {

    val items = listOf(Screen.List, Screen.Settings)

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }) }
    ) { innerPadding ->
        Row(modifier = Modifier.padding(innerPadding)) {
            NavigationRail(backgroundColor = MaterialTheme.colors.primary) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    NavigationRailItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.name
                            )
                        },
                        label = { Text(text = screen.name) },
                        selected = currentDestination?.route?.let { it == screen.path } ?: false,
                        onClick = {
                            navController.navigate(screen.path) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }

            NavHost(navController = navController, startDestination = Screen.List.path) {
                composable(Screen.List.path) {
                    CityListWithDetailUi(viewModel = viewModel)
                }
                composable(Screen.Settings.path) {
                    SettingsUi(themeStore = themeStore)
                }
            }
        }
    }
}