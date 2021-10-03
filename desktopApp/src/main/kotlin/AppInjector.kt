import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.inject

object AppInjector : KoinComponent {
    val crepesRepository by inject<CrepesRepository>()
}
