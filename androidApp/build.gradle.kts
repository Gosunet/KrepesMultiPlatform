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
    implementation("com.google.android.material:material:${Versions.material}")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}")

    // Koin AndroidX ViewModel feature
    implementation("org.koin:koin-androidx-viewmodel:${Versions.koin}")
    // Koin AndroidX Fragment Factory
    implementation("org.koin:koin-androidx-fragment:${Versions.koin}")

    // Compose
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    // Tooling support (Previews, etc.)
    implementation("androidx.ui:ui-tooling:${Versions.compose}")
    implementation("androidx.compose.ui:ui-graphics:${Versions.compose}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${Versions.compose}")
    // Material Design
    implementation("androidx.compose.material:material:${Versions.compose}")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:${Versions.compose}")
    implementation("androidx.compose.material:material-icons-extended:${Versions.compose}")

    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:${Versions.compose}")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:${Versions.navigationCompose}")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:1.0.0-alpha03")
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
    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.4.0"
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
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }
}
