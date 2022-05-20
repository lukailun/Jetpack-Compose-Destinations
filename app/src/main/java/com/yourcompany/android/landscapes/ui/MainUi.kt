package com.yourcompany.android.landscapes.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.yourcompany.android.landscapes.data.ThemeStore
import com.yourcompany.android.landscapes.data.ViewModel
import com.yourcompany.android.landscapes.theme.LandscapesTheme

@Composable
fun MainUi(
    viewModel: ViewModel = ViewModel(),
    windowSize: WindowSize,
    themeStore: ThemeStore
) {
    val navController = rememberNavController()
    val theme by themeStore.getTheme().collectAsState(initial = 0)
    val systemUiController = rememberSystemUiController()

    LandscapesTheme(theme = theme) {

        val statusBarColor = MaterialTheme.colors.primaryVariant

        SideEffect {
            systemUiController.setSystemBarsColor(
                color = statusBarColor,
                darkIcons = false
            )
        }

        if (windowSize == WindowSize.Compact) {
            CompatUi(navController = navController, viewModel = viewModel, themeStore = themeStore)
        } else {
            ExpandedUi(
                navController = navController,
                viewModel = viewModel,
                themeStore = themeStore
            )
        }
    }
}

sealed class Screen(val name: String, val path: String, val icon: ImageVector) {

    object List : Screen(name = "List", path = "list", icon = Icons.Filled.List)
    object Settings : Screen(name = "Settings", path = "settings", icon = Icons.Filled.Settings)

}