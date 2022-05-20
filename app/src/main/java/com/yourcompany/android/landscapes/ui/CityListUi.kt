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