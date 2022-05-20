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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourcompany.android.landscapes.data.CityOverview
import com.yourcompany.android.landscapes.data.ViewModel

@OptIn(ExperimentalMaterialApi::class)
@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun CityListUi(
  modifier: Modifier = Modifier,
  viewModel: ViewModel = ViewModel(),
  onCitySelected: (CityOverview) -> Unit = {}
) {

  Column(modifier = modifier.verticalScroll(rememberScrollState())) {
    viewModel.cities.forEach { city ->
      Card(
        onClick = { onCitySelected(city) },
        modifier = Modifier
          .fillMaxWidth()
          .padding(all = 8.dp),
        elevation = 4.dp
      ) {
        Box(contentAlignment = Alignment.BottomEnd) {
          Image(
            painter = painterResource(id = city.image),
            contentDescription = city.name,
            contentScale = ContentScale.Crop
          )
          Column(
            modifier = Modifier
              .padding(all = 8.dp),
            horizontalAlignment = Alignment.End
          ) {
            Text(
              text = city.name,
              color = Color.White,
              style = MaterialTheme.typography.h5
            )
            Text(
              text = "Picture by ${city.author}",
              color = Color.White,
              style = MaterialTheme.typography.caption
            )
          }
        }
      }
    }
  }
}