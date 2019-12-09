package com.strv.mlyko.kitchensink

import Depends
import Versions
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KitchenSinkPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		target.configureAndroid()
		target.configureDependencies()
		target.tasks.withType<KotlinCompile> {
			kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
		}
	}
}

private fun Project.configureAndroid() = project.extensions.getByType<BaseExtension>().run {
	compileSdkVersion(Versions.compileSdkVersion)
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	defaultConfig {
		minSdkVersion(Versions.minSdkVersion)
		targetSdkVersion(Versions.targetSdkVersion)
		versionCode = 1
		versionName = "1"
	}

	sourceSets {
		getByName("main") {
			java.srcDir("src/main/kotlin")
		}
	}
}

private fun Project.configureDependencies() = dependencies {
	add("implementation", Depends.Kotlin.stdlib)
}
