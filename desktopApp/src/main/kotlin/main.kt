import androidx.compose.desktop.Window
import androidx.compose.ui.unit.IntSize
import com.gosunet.krepesmultiplatform.shared.Greeting
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.di.initKoin
import kotlinx.coroutines.runBlocking

fun main() {
    // init koin
    @Suppress("EXPERIMENTAL_API_USAGE")
    initKoin()

    val crepesList = mutableListOf<Crepe>()
    runBlocking {
        crepesList.addAll(AppInjector.crepesRepository.getCrepes())
    }

    Window(title = "Compose for ${Greeting().greeting()}", size = IntSize(1000, 1000)) {
        CrepesList(crepesList)
    }
}
