plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

apply(from="../gradle/ktlint.gradle.kts")

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
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.0")

    // Koin AndroidX ViewModel feature
    implementation("org.koin:koin-androidx-viewmodel:3.0.0-alpha-4")
    // Koin AndroidX Fragment Factory
    implementation("org.koin:koin-androidx-fragment:3.0.0-alpha-4")
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.gosunet.krepesmultiplatform.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
