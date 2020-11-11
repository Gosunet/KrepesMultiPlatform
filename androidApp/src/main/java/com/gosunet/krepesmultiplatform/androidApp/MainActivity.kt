package com.gosunet.krepesmultiplatform.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.gosunet.krepesmultiplatform.androidApp.features.crepeslist.CrepesList
import com.gosunet.krepesmultiplatform.androidApp.features.crepeslist.CrepesListViewModel
import com.gosunet.krepesmultiplatform.androidApp.features.selectcity.SelectCity
import com.gosunet.krepesmultiplatform.androidApp.features.shared.KrepesThemes
import com.gosunet.krepesmultiplatform.shared.data.City
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
    object SelectCityScreen : Screen("SelectCityScreen")
    object CrepesListScreen : Screen("CrepesListScreen")
    object CrepesDetailScreen : Screen("CrepesDetailScreen")
}

@Composable
fun MainLayout(crepesListViewModel: CrepesListViewModel) {
    val navController = rememberNavController()

    KrepesThemes {
        NavHost(
            navController,
            startDestination = Screen.SelectCityScreen.title
        ) { // start at select city
            composable(Screen.SelectCityScreen.title) {
                SelectCity(citySelected = {
                    navController.navigate(Screen.CrepesListScreen.title + "/${it.name}")
                })
            }
            composable(Screen.CrepesListScreen.title + "/{city}") { backStackEntry ->
                CrepesList(crepesListViewModel, City.valueOf(backStackEntry.arguments!!.getString("city")!!))
            }
        }
    }
}
