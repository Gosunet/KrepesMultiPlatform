plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.5.30"
}
apply(from = "../buildSrc/ktlint.gradle.kts")

group = "com.gosunet.krepesmultiplatform"
version = "1.0"

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    android()

    val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        summary = "shared library"
        homepage = "https://github.com/JetBrains/kotlin"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
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
                implementation("io.insert-koin:koin-core:3.1.2")
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
//                implementation("io.mockk:mockk-common:1.12.0")
//                implementation("io.mockk:mockk:1.12.0")
                implementation("io.insert-koin:koin-test:3.1.2")
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
                implementation("junit:junit:4.13.2")
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
