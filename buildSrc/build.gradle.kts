plugins {
	`kotlin-dsl`
	groovy
}

repositories {
	google()
	jcenter()
	maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
}

kotlinDslPluginOptions {
	experimentalWarning.set(false)
}

val androidGradle = "4.0.0-beta01"
val kotlin = "1.3.70-eap-42"

dependencies {
	implementation("com.android.tools.build:gradle:$androidGradle")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
	implementation(gradleApi())
	implementation(localGroovy())
}
