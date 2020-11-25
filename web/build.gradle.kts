plugins {
    kotlin("js")
}

dependencies {
    implementation(kotlin("stdlib-js"))

    // Koin for Kotlin
    implementation("org.koin:koin-core:${Versions.koin}")

    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")

    implementation("org.jetbrains:kotlin-react:16.13.1-pre.110-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.110-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.110-kotlin-1.4.0")
    implementation(npm("react", "16.13.0"))
    implementation(npm("react-dom", "16.13.0"))

    // Styled-Css
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.110-kotlin-1.4.0")
    implementation(npm("styled-components", "4.4.0"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))

    implementation(project(":shared"))
}


kotlin {
    js {
        browser {}
        useCommonJs()
        binaries.executable()
    }
}
repositories {
    mavenCentral()
}
