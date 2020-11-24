import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import com.gosunet.krepesmultiplatform.shared.di.initKoin
import react.child
import react.createContext
import react.dom.render

object AppDependencies {
    val repository: CrepesRepository = CrepesRepository()
}

val AppDependenciesContext = createContext<AppDependencies>()

fun main() {
    @Suppress("EXPERIMENTAL_API_USAGE")
    initKoin()
    render(kotlinx.browser.document.getElementById("root")) {
        AppDependenciesContext.Provider(AppDependencies) {
            child(App)
        }
    }
}
