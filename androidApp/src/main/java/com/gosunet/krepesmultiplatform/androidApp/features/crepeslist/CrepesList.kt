package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe

@Composable
fun CrepesList(crepesListViewModel: CrepesListViewModel, city: City = City.Brest) {
    val crepesList = crepesListViewModel.getCrepes(city)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Crepes liste") })
        },
        bodyContent = {
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
    Row(
        modifier = Modifier.fillMaxWidth() then Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
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

        Spacer(modifier = Modifier.preferredSize(20.dp))

        Column {
            Text(text = crepe.name, style = TextStyle(fontSize = 20.sp))
            Text(
                text = crepe.description,
                style = TextStyle(color = Color.DarkGray, fontSize = 14.sp)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview(@PreviewParameter(CrepesProvider::class) crepe: Crepe) {
    MaterialTheme {
        CrepeView(crepe)
    }
}
