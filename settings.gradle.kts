pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "KrepesMultiPlatform"

include(":androidApp")
include(":shared")
include(":desktopApp")
include(":web")


