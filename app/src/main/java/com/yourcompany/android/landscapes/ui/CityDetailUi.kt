package com.yourcompany.android.landscapes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourcompany.android.landscapes.data.CityOverview
import com.yourcompany.android.landscapes.data.Turin
import com.yourcompany.android.landscapes.data.ViewModel

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun CityDetailUi(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = ViewModel(),
    city: CityOverview = Turin,
    isBigLayout: Boolean = false
) {

    val photos = viewModel.getPicturesForCity(city = city)
    val columns = if (isBigLayout) {
        4
    } else {
        2
    }

    Column(
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = city.name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns)
        ) {
            items(photos) { photo ->
                Image(
                    painter = painterResource(id = photo.image),
                    contentDescription = photo.author,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }
        }
    }
}