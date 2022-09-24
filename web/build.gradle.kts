plugins {
    kotlin("js")
}

dependencies {
    implementation(kotlin("stdlib-js"))

    // Koin for Kotlin
    implementation("io.insert-koin:koin-core:${Versions.koin}")

    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")

    //React, React DOM + Wrappers
    implementation("org.jetbrains:kotlin-react:17.0.2-pre.154-kotlin-1.5.0")
    implementation("org.jetbrains:kotlin-react-dom:17.0.2-pre.154-kotlin-1.5.0")
    implementation(npm("react", "16.13.0"))
    implementation(npm("react-dom", "16.13.0"))

    //Kotlin Styled
    implementation("org.jetbrains:kotlin-styled:5.2.3-pre.154-kotlin-1.5.0")
    implementation(npm("styled-components", "~5.2.3"))

    implementation(project(":shared"))
}


kotlin {
    kotlin {
        js {
            browser {
                commonWebpackConfig {
                    cssSupport.enabled = true
                }
            }
            binaries.executable()
        }
    }
}
repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
}
