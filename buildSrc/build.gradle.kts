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

val androidGradle = "4.0.0-alpha06"
val kotlin = "1.3.61"

dependencies {
	implementation("com.android.tools.build:gradle:$androidGradle")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
	implementation(gradleApi())
	implementation(localGroovy())
}
