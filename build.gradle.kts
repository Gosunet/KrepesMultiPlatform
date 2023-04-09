buildscript {
    val kotlinVersion: String by project

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin:1.0.0-ALPHA-4")
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.8.10-1.0.9")
    }
}
group = "com.gosunet.krepesmultiplatform"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
        maven(url = "https://jitpack.io")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-coroutines/maven")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    }
}

allprojects {
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module("org.jetbrains.compose.compiler:compiler")).apply {
                using(module("androidx.compose.compiler:compiler:${Versions.compose}"))
            }
        }
    }
}
