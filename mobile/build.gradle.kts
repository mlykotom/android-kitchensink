plugins {
	id("com.android.application")
	`kotlin-android`
	`kotlin-kapt`
	id("androidx.navigation.safeargs.kotlin")
	id("com.strv.mlyko.kitchensink")
}

android {
	defaultConfig {
		versionCode = 156
		versionName = "1.56"
	}

	buildFeatures {
		dataBinding = true
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
}

dependencies {
	implementation(project(":auth"))
	implementation(project(":core"))
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
	implementation(Depends.AndroidX.Lifecycle.lifecycleCommonJava8)
	implementation(Depends.AndroidX.fragmentKtx)

	implementation(Depends.Google.materialComponents)

	implementation(Depends.DI.dagger)
	kapt(Depends.DI.daggerCompiler)
	kapt(Depends.DI.daggerAnnotationProcessor)

	compileOnly(Depends.DI.Assisted.annotations)
	kapt(Depends.DI.Assisted.processor)
}
