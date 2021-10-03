plugins {
    id("com.android.application")
    kotlin("android")
}

apply(from="../buildSrc/ktlint.gradle.kts")

group = "com.gosunet.krepesmultiplatform"
version = "1.0"

dependencies {
    implementation(project(":shared"))
    // implementation("androidx.compose.compiler:compiler:${Versions.kotlinCompiler}")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    // Koin AndroidX ViewModel feature
    implementation("io.insert-koin:koin-android:3.1.2")

    // Compose
    implementation("androidx.compose.ui:ui:1.0.3")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.3")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.3")
    // Material Design
    implementation("androidx.compose.material:material:1.0.3")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.3")
    implementation("androidx.compose.material:material-icons-extended:1.0.3")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.3.1")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-rc01")

    // Integration with observables
    implementation("androidx.compose.runtime:runtime:1.0.3")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.3")

    // Material Design
    implementation("androidx.compose.material:material:1.0.3")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.3")
    implementation("androidx.compose.material:material-icons-extended:1.0.3")

    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.3")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")

    // Coil
    implementation("io.coil-kt:coil-compose:1.3.2")
    // Lottie
    implementation("com.airbnb.android:lottie-compose:4.1.0")
}
android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.gosunet.krepesmultiplatform.androidApp"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    // Set both the Java and Kotlin compilers to target Java 8.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
