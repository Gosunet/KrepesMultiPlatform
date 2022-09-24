import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.gosunet.krepesmultiplatform.shared.Greeting
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import com.gosunet.krepesmultiplatform.shared.di.initKoin

private val koin = initKoin().koin

fun main() = application {
    // init koin
    val windowState = rememberWindowState()

    var crepesList by remember { mutableStateOf(emptyList<Crepe>()) }

    val crepesRepository = koin.get<CrepesRepository>()

    LaunchedEffect(true) {
        crepesList = crepesRepository.getCrepes()
    }

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Compose for ${Greeting().greeting()}"
    )
    {
        CrepesList(crepesList)
    }
}
