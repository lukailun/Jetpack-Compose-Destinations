package com.yourcompany.android.landscapes.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.yourcompany.android.landscapes.data.ViewModel

@Composable
fun CityListWithDetailUi(viewModel: ViewModel = ViewModel()) {

    var selectedCity by remember { mutableStateOf(viewModel.cities[0]) }

    Row {
        CityListUi(
            modifier = Modifier.weight(0.3f),
            viewModel = viewModel
        ) {
            selectedCity = it
        }

        CityDetailUi(
            modifier = Modifier.weight(0.7f),
            viewModel = viewModel, city = selectedCity,
            isBigLayout = true
        )
    }
}