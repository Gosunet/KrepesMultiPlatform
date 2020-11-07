plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

apply(from="../buildSrc/ktlint.gradle.kts")

group = "com.gosunet.krepesmultiplatform"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:$material")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine")

    // Koin AndroidX ViewModel feature
    implementation("org.koin:koin-androidx-viewmodel:$koin")
    // Koin AndroidX Fragment Factory
    implementation("org.koin:koin-androidx-fragment:$koin")

    // Compose
    implementation("androidx.compose.ui:ui:$compose")
    // Tooling support (Previews, etc.)
    implementation("androidx.ui:ui-tooling:$compose")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$compose")
    // Material Design
    implementation("androidx.compose.material:material:$compose")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$compose")
    implementation("androidx.compose.material:material-icons-extended:$compose")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:$compose")
}
android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.gosunet.krepesmultiplatform.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    // Set both the Java and Kotlin compilers to target Java 8.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.4.0"
        kotlinCompilerExtensionVersion = "1.0.0-alpha05"
    }

}
