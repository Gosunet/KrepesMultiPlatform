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
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Koin AndroidX ViewModel feature
    implementation("io.insert-koin:koin-android:${Versions.koin}")

    // Compose
    implementation("androidx.compose.ui:ui:1.4.1")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.4.1")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.4.1")
    // Material Design
    implementation("androidx.compose.material:material:1.4.1")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.4.1")
    implementation("androidx.compose.material:material-icons-extended:1.4.1")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.7.0")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Integration with observables
    implementation("androidx.compose.runtime:runtime:1.4.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.4.1")

    // Material Design
    implementation("androidx.compose.material:material:1.4.1")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.4.1")
    implementation("androidx.compose.material:material-icons-extended:1.4.1")

    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.4.1")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha09")

    // Coil
    implementation("io.coil-kt:coil-compose:2.3.0")
    // Lottie
    implementation("com.airbnb.android:lottie-compose:4.1.0")
}
android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.gosunet.krepesmultiplatform.androidApp"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    packagingOptions {
        resources {
            excludes += setOf("META-INF/*.kotlin_module")
        }
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    namespace = "com.gosunet.krepesmultiplatform.androidApp"
}
