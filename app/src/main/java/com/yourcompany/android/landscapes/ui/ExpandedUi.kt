package com.yourcompany.android.landscapes.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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

@OptIn(ExperimentalMaterialApi::class)
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
      // TODO: Add NavigationRail here
      // TODO: Move NavHost here
    }
    // TODO: Add NavHost for tablets here
  }
}