import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    groovy
}

repositories {
    google()
    jcenter()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}