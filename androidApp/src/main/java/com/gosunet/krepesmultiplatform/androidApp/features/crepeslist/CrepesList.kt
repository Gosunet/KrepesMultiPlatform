package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableAmbient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.gosunet.krepesmultiplatform.androidApp.features.shared.Loader
import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe

@ExperimentalAnimationApi
@Composable
fun CrepesList(crepesListViewModel: CrepesListViewModel, city: City = City.Brest) {
    val crepesList = crepesListViewModel.getCrepes(city)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Crepes liste") })
        },
        bodyContent = {
            AnimatedVisibility(visible = crepesList.isEmpty()) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(50.dp)
                ) {
                    Loader()
                }
            }
            LazyColumnFor(
                items = crepesList,
                itemContent = { crepe ->
                    CrepeView(crepe)
                }
            )
        }
    )
}

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
                ImageView(ContextAmbient, crepe)

                Spacer(modifier = Modifier.preferredSize(20.dp))

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

@Composable
private fun ImageView(
    ContextAmbient: ProvidableAmbient<Context>,
    crepe: Crepe
) {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    Glide.with(ContextAmbient.current).asBitmap()
        .load(crepe.image)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })

    if (bitmap != null)
        Image(
            bitmap!!.asImageAsset(),
            Modifier.preferredSize(70.dp).clip(shape = RoundedCornerShape(4.dp))
        )
}

@Preview
@Composable
fun DefaultPreview(@PreviewParameter(CrepesProvider::class) crepe: Crepe) {
    MaterialTheme {
        CrepeView(crepe)
    }
}
