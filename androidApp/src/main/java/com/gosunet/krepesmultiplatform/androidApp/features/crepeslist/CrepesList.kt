package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe

@Composable
fun CrepesList(crepesListViewModel: CrepesListViewModel, city: City = City.Brest) {
    val crepesList = crepesListViewModel.getCrepes(city)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Crepes list") })
        },
        bodyContent = {
            LazyColumnFor(items = crepesList, itemContent = { crepe ->
                CrepeView(crepe.name, crepe.description, crepe.url, crepe.rate, crepe.image)
            })
        }
    )
}

@Composable
fun CrepeView(name: String, description: String, url: String, rate: String, image: String) {
    Row(
        modifier = Modifier.fillMaxWidth() then Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.preferredSize(60.dp))

        Column {
            Text(text = name, style = TextStyle(fontSize = 20.sp))
            Text(text = description, style = TextStyle(color = Color.DarkGray, fontSize = 14.sp))
        }
    }
}

@Preview
@Composable
fun DefaultPreview(@PreviewParameter(CrepesProvider::class) crepe: Crepe) {
    MaterialTheme {
        CrepeView(crepe.name, crepe.description, crepe.url, crepe.rate, crepe.image)
    }
}
