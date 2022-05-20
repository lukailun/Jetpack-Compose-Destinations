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

package com.yourcompany.android.landscapes.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightThemeColors1 = lightColors(
  primary = colorPrimaryTheme1,
  primaryVariant = colorPrimaryDarkTheme1,
  onPrimary = Color.White,
  secondary = colorAccentTheme1,
  secondaryVariant = colorAccentTheme1,
  onSecondary = Color.White,
  error = Color.Red,
  onBackground = Color.Black
)

private val DarkThemeColors1 = darkColors(
  primary = colorPrimaryTheme1,
  primaryVariant = colorPrimaryDarkTheme1,
  onPrimary = Color.White,
  secondary = colorAccentTheme1,
  secondaryVariant = colorAccentTheme1,
  onSecondary = Color.Black,
  error = Color.Red,
  onBackground = Color.White
)

val LightThemeColors2 = lightColors(
  primary = colorPrimaryTheme2,
  primaryVariant = colorPrimaryDarkTheme2,
  onPrimary = Color.White,
  secondary = colorAccentTheme2,
  secondaryVariant = colorAccentTheme2,
  onSecondary = Color.White,
  error = Color.Red,
  onBackground = Color.Black
)

private val DarkThemeColors2 = darkColors(
  primary = colorPrimaryTheme2,
  primaryVariant = colorPrimaryDarkTheme2,
  onPrimary = Color.White,
  secondary = colorAccentTheme2,
  secondaryVariant = colorAccentTheme2,
  onSecondary = Color.Black,
  error = Color.Red,
  onBackground = Color.White
)

val LightThemeColors3 = lightColors(
  primary = colorPrimaryTheme3,
  primaryVariant = colorPrimaryDarkTheme3,
  onPrimary = Color.White,
  secondary = colorAccentTheme3,
  secondaryVariant = colorAccentTheme3,
  onSecondary = Color.White,
  error = Color.Red,
  onBackground = Color.Black
)

private val DarkThemeColors3 = darkColors(
  primary = colorPrimaryTheme3,
  primaryVariant = colorPrimaryDarkTheme3,
  onPrimary = Color.White,
  secondary = colorAccentTheme3,
  secondaryVariant = colorAccentTheme3,
  onSecondary = Color.Black,
  error = Color.Red,
  onBackground = Color.White
)

@Composable
fun LandscapesTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  theme: Int = 0,
  content: @Composable () -> Unit
) {
  MaterialTheme(
    colors = if (darkTheme) darkTheme(theme = theme) else lightTheme(theme = theme),
    shapes = LandscapeShapes,
    typography = LandscapesTypography,
    content = content
  )
}

private fun lightTheme(theme: Int) = when (theme) {
  0 -> LightThemeColors1
  1 -> LightThemeColors2
  else -> LightThemeColors3
}

private fun darkTheme(theme: Int) = when (theme) {
  0 -> DarkThemeColors1
  1 -> DarkThemeColors2
  else -> DarkThemeColors3
}