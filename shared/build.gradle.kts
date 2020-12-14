plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.4.10"
}
apply(from = "../buildSrc/ktlint.gradle.kts")

group = "com.gosunet.krepesmultiplatform"
version = "1.0"

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
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
}

kotlin {
    android()
    ios()
    cocoapods {
        summary = "shared library"
        homepage = "https://github.com/JetBrains/kotlin"
    }
    jvm("desktop")

    js {
        browser {
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // koin
                implementation("org.koin:koin-core:${Versions.koin}")
                // ktor
                implementation("io.ktor:ktor-client-core:${Versions.ktor}")
                implementation("io.ktor:ktor-client-json:${Versions.ktor}")
                implementation("io.ktor:ktor-client-logging:${Versions.ktor}")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
                // coroutine
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}") {
                    isForce = true
                }
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.mockk:mockk-common:1.9.3")
                implementation("io.mockk:mockk:1.9.3")
                implementation("org.koin:koin-test:${Versions.koin}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:${Versions.ktor}")
                implementation("com.google.android.material:material:${Versions.material}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.1")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor}")
            }
        }
        val iosTest by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor}")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-apache:${Versions.ktor}")
            }
        }
        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:${Versions.ktor}")
            }
        }
        val jsTest by getting
    }
}
