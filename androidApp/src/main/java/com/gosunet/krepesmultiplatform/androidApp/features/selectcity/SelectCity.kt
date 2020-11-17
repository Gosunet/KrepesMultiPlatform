package com.gosunet.krepesmultiplatform.androidApp.features.selectcity

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.ui.tooling.preview.Preview
import com.gosunet.krepesmultiplatform.androidApp.R
import com.gosunet.krepesmultiplatform.shared.data.City

@Composable
@Preview
fun SelectCity(citySelected: (city: City) -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.select_city)) })
        },
        bodyContent = {
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                City.values().forEach {
                    Button(
                        onClick = { citySelected(it) }, modifier = Modifier.padding(Dp(10f))
                    ) {
                        Text(it.name)
                    }
                }
            }
        }
    )
}
