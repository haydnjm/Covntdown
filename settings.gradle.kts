pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

}

rootProject.name = "Covntdown"

enableFeaturePreview("GRADLE_METADATA")

include(":androidApp", ":shared")
include(":shared")

