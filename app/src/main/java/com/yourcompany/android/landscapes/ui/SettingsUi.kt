/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.yourcompany.android.landscapes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yourcompany.android.landscapes.data.Theme
import com.yourcompany.android.landscapes.data.ThemeStore
import com.yourcompany.android.landscapes.theme.LightThemeColors1
import com.yourcompany.android.landscapes.theme.LightThemeColors2
import com.yourcompany.android.landscapes.theme.LightThemeColors3
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
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