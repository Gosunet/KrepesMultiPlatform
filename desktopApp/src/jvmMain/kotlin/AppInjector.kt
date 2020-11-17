import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

object AppInjector : KoinComponent {
    val crepesRepository: CrepesRepository by inject()
}
