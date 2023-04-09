package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gosunet.krepesmultiplatform.androidApp.features.shared.Loader
import com.gosunet.krepesmultiplatform.shared.Greeting
import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe

@ExperimentalAnimationApi
@Composable
fun CrepesList(crepesListViewModel: CrepesListViewModel, city: City = City.Brest) {
    val crepesList = crepesListViewModel.getCrepes(city)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Krepes multiplatform ${Greeting().greeting()}") })
        },
        content = { padding ->
            AnimatedVisibility(visible = crepesList.isEmpty()) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(50.dp)
                ) {
                    Loader()
                }
            }
            LazyColumn {
                items(crepesList) { crepe ->
                    CrepeView(crepe)
                }
            }
        }
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CrepeView(crepe: Crepe) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(6.dp)
            ) {
                ImageView(crepe)

                Spacer(modifier = Modifier.size(20.dp))

                Column {
                    Text(text = crepe.name, style = TextStyle(fontSize = 20.sp))
                    Text(
                        text = crepe.description,
                        style = TextStyle(color = Color.DarkGray, fontSize = 14.sp)
                    )
                    crepe.rate?.let {
                        Text(
                            text = "Note : $it/5",
                            style = TextStyle(color = Color.DarkGray, fontSize = 14.sp),
                            modifier = Modifier.padding(top = Dp(4f))
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun ImageView(
    crepe: Crepe
) {
    Image(
        painter = rememberImagePainter(crepe.image),
        contentDescription = "Crepe image",
        modifier = Modifier
            .size(70.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    )
}

@Preview
@Composable
fun DefaultPreview(@PreviewParameter(CrepesProvider::class) crepe: Crepe) {
    MaterialTheme {
        CrepeView(crepe)
    }
}
