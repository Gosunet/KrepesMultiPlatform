package com.gosunet.krepesmultiplatform.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import com.gosunet.krepesmultiplatform.androidApp.features.crepeslist.CrepesListViewModel
import com.gosunet.krepesmultiplatform.androidApp.features.shared.KrepesThemes
import com.gosunet.krepesmultiplatform.androidApp.features.shared.PersonProvider
import com.gosunet.krepesmultiplatform.shared.Greeting
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val crepesListViewModel: CrepesListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout(crepesListViewModel)
        }
    }
}

sealed class Screen(val title: String) {
    object PersonListScreen : Screen("PersonList")
    object PersonDetailsDetails : Screen("PersonDetails")
}

@Composable
fun MainLayout(crepesListViewModel: CrepesListViewModel) {
    val navController = rememberNavController()

    KrepesThemes {
        NavHost(navController, startDestination = Screen.PersonListScreen.title) {
            composable(Screen.PersonListScreen.title) {
                CrepesList(crepesListViewModel)
            }
        }
    }
}

@Composable
fun CrepesList(crepesListViewModel: CrepesListViewModel) {
    val crepesList = crepesListViewModel.crepes
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

fun greet(): String {
    return Greeting().greeting()
}

@Preview
@Composable
fun DefaultPreview(@PreviewParameter(PersonProvider::class) crepe: Crepe) {
    MaterialTheme {
        CrepeView(crepe.name, crepe.description, crepe.url, crepe.rate, crepe.image)
    }
}
