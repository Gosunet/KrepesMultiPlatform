import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import react.RProps
import react.dom.h1
import react.dom.li
import react.dom.ul
import react.functionalComponent
import react.useContext
import react.useEffectWithCleanup
import react.useState

val App = functionalComponent<RProps> { _ ->
    val appDependencies = useContext(AppDependenciesContext)
    val repository: CrepesRepository = appDependencies.repository

    val (crepe, setCrepe) = useState(emptyList<Crepe>())

    useEffectWithCleanup(dependencies = listOf()) {
        val mainScope = MainScope()

        mainScope.launch {
            setCrepe(repository.getCrepes(City.Brest))
        }
        return@useEffectWithCleanup { mainScope.cancel() }
    }

    h1 {
        +"Krepes multiplatform"
    }
    ul {
        crepe.forEach { item ->
            li {
                +"${item.name} (${item.description})"
            }
        }
    }
}
