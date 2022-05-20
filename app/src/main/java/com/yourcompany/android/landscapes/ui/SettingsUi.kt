package com.yourcompany.android.landscapes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yourcompany.android.landscapes.data.Theme
import com.yourcompany.android.landscapes.data.ThemeStore
import com.yourcompany.android.landscapes.theme.LightThemeColors1
import com.yourcompany.android.landscapes.theme.LightThemeColors2
import com.yourcompany.android.landscapes.theme.LightThemeColors3
import kotlinx.coroutines.launch

@Composable
fun SettingsUi(
    themeStore: ThemeStore
) {

    val radioOptions = listOf(
        Theme("Theme 1", LightThemeColors1),
        Theme("Theme 2", LightThemeColors2),
        Theme("Theme 3", LightThemeColors3)
    )

    val theme by themeStore.getTheme().collectAsState(initial = 0)

    var selected = radioOptions[theme]
    val scope = rememberCoroutineScope()

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Settings") },
            backgroundColor = MaterialTheme.colors.primary
        )
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Theme",
                style = MaterialTheme.typography.h4
            )

            Column(
                modifier = Modifier
                    .selectableGroup()
                    .padding(top = 16.dp)
            ) {
                radioOptions.forEachIndexed { index, currentTheme ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (currentTheme.name == selected.name),
                            onClick = {
                                selected = currentTheme
                            }
                        )
                        .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (currentTheme.name == selected.name),
                            onClick = {
                                selected = currentTheme
                                scope.launch {
                                    themeStore.setTheme(index)
                                }
                            }
                        )

                        RadioButtonLine(theme = currentTheme)
                    }
                }
            }
        }
    }
}

@Composable
private fun RadioButtonLine(theme: Theme) {

    Text(text = theme.name, modifier = Modifier.padding(end = 8.dp))

    Box(
        modifier = Modifier
            .size(width = 24.dp, height = 24.dp)
            .background(theme.colors.primary)
    )

    Box(
        modifier = Modifier
            .size(width = 24.dp, height = 24.dp)
            .background(theme.colors.primaryVariant)
    )

    Box(
        modifier = Modifier
            .size(width = 24.dp, height = 24.dp)
            .background(theme.colors.secondary)
    )
}