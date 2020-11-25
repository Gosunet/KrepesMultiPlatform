import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.css.Color
import kotlinx.css.FontWeight
import kotlinx.css.ListStyleType
import kotlinx.css.Position
import kotlinx.css.QuotedString
import kotlinx.css.TextAlign
import kotlinx.css.background
import kotlinx.css.bottom
import kotlinx.css.color
import kotlinx.css.content
import kotlinx.css.fontFamily
import kotlinx.css.fontSize
import kotlinx.css.fontWeight
import kotlinx.css.height
import kotlinx.css.left
import kotlinx.css.listStyleType
import kotlinx.css.margin
import kotlinx.css.marginBottom
import kotlinx.css.marginTop
import kotlinx.css.maxWidth
import kotlinx.css.padding
import kotlinx.css.paddingBottom
import kotlinx.css.pc
import kotlinx.css.position
import kotlinx.css.px
import kotlinx.css.textAlign
import kotlinx.css.width
import react.RProps
import react.functionalComponent
import react.useContext
import react.useEffectWithCleanup
import react.useState
import styled.css
import styled.styledBody
import styled.styledH1
import styled.styledH4
import styled.styledLi
import styled.styledP
import styled.styledUl

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
    styledBody {
        css {
            margin = "40px auto"
            fontWeight = FontWeight.normal
            fontSize = 16.px
            maxWidth = 80.pc
        }
        styledH1 {
            css {
                fontFamily = "Verdana"
                textAlign = TextAlign.center;
            }
            +"Welcome to Krepes multiplatform \uD83D\uDC4B"
        }
        styledUl {
            css {
                fontFamily = "Verdana"
            }
            crepe.forEach { item ->
                styledLi {
                    css {
                        listStyleType = ListStyleType.none
                        position = Position.relative
                        fontSize = 20.px
                        padding = "15px"
                        marginBottom = 15.px
                        background = "#0e0fee"
                        color = Color.white
                    }
                    styledH4 {
                        css {
                            position = Position.relative
                            paddingBottom = 10.px
                            margin = "0"
                            after {
                                content = QuotedString("")
                                position = Position.absolute
                                bottom = 0.px
                                left = 0.px
                                width = 25.px
                                height = 2.px
                                background = "white"
                            }
                        }
                        +item.name
                    }
                    styledP {
                        css {
                            margin = "0"
                            fontSize = 14.px
                            marginTop = 15.px
                        }
                        +item.description
                    }
                }
            }
        }
    }
}
