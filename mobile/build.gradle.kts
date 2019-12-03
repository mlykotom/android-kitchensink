import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("com.android.application")
	kotlin("android")
	kotlin("kapt")
	id("androidx.navigation.safeargs.kotlin")
}

android {
	compileSdkVersion(Versions.compileSdkVersion)

	defaultConfig {
		minSdkVersion(Versions.minSdkVersion)
		targetSdkVersion(Versions.targetSdkVersion)
		versionCode = 1
		versionName = "1.0"
	}

	sourceSets {
		getByName("main") {
			java.srcDir("src/main/kotlin")
		}
	}

	dataBinding {
		isEnabled = true
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {
	implementation(Depends.Kotlin.stdlib)

	implementation(Depends.AndroidX.appcompat)
	implementation(Depends.AndroidX.coreKtx)
	implementation(Depends.AndroidX.constraintLayout)
	implementation(Depends.AndroidX.navigationFragment)
	implementation(Depends.AndroidX.navigationUI)
	implementation(Depends.AndroidX.viewPager2)
	implementation(Depends.AndroidX.preferences)

	implementation(Depends.AndroidX.Lifecycle.extensions)
	implementation(Depends.AndroidX.Lifecycle.common)
	implementation(Depends.AndroidX.Lifecycle.viewModelSavedState)
	implementation(Depends.AndroidX.Lifecycle.liveDataKtx)
	implementation(Depends.AndroidX.Lifecycle.runtimeKtx)
	implementation(Depends.AndroidX.Lifecycle.viewModelKtx)

	implementation(Depends.Google.materialComponents)

	implementation(Depends.DI.dagger)
	implementation(Depends.DI.daggerAndroid)
	kapt(Depends.DI.daggerCompiler)
	kapt(Depends.DI.daggerAnnotationProcessor)

}
