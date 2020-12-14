import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.data.CrepesApi
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import com.gosunet.krepesmultiplatform.shared.di.commonModule
import com.gosunet.krepesmultiplatform.shared.di.networkingModule
import io.ktor.util.KtorExperimentalAPI
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockkStatic
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class CrepesRepositoryTest : KoinTest {
    @MockK
    lateinit var crepesApi: CrepesApi

    @SpyK
    var crepesRepository = CrepesRepository()

    @KtorExperimentalAPI
    @BeforeTest
    fun setUp() {
        startKoin {
            modules(commonModule, networkingModule)
        }
        MockKAnnotations.init(this) // turn relaxUnitFun on for all mocks
    }

    @Test
    fun ifCityIsBrestThenGetOnlyCrepesWhenGettingCrepes() = runBlockingTest {
        coEvery { crepesRepository.getCrepes(City.Brest) } returns listOf(
            Crepe("Crêpes", "Crêpes", "crepe.com", "1.1", "image.com"),
        )
        coEvery { crepesRepository.getCrepes(City.Rennes) } returns listOf(
            Crepe("Galettes", "Galettes", "crepe.com", "1.1", "image.com"),
        )
        val crepes = crepesRepository.getCrepes(City.Brest)

        assertTrue(crepes[0].name == "Crêpes")
    }
}
