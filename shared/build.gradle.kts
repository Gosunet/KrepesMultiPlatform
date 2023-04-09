import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    id("com.rickclephas.kmp.nativecoroutines")
    id("io.github.luca992.multiplatform-swiftpackage") version "2.0.5-arm64"
}
apply(from = "../buildSrc/ktlint.gradle.kts")

group = "com.gosunet.krepesmultiplatform"
version = "1.0"

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    namespace = "com.gosunet.krepesmultiplatform.android"

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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    macosX64("macOS")

    cocoapods {
        summary = "shared library"
        homepage = "https://github.com/JetBrains/kotlin"
    }

    jvm()

    js(IR) {
        browser {
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // koin
                implementation("io.insert-koin:koin-core:${Versions.koin}")
                // ktor
                implementation("io.ktor:ktor-client-core:${Versions.ktor}")
                implementation("io.ktor:ktor-client-json:${Versions.ktor}")
                implementation("io.ktor:ktor-client-logging:${Versions.ktor}")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
                implementation("io.ktor:ktor-client-content-negotiation:${Versions.ktor}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}")
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
                implementation("io.insert-koin:koin-test:${Versions.koin}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:${Versions.ktor}")
                implementation("com.google.android.material:material:${Versions.material}")
            }
        }
        val androidTest by creating {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor}")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-java:${Versions.ktor}")
            }
        }
        val jvmTest by getting {
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

multiplatformSwiftPackage {
    packageName("KrepesMultiPlatformKit")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("14") }
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
}