plugins {
	id("com.android.library")
	`kotlin-android`
	`kotlin-kapt`
	id("androidx.navigation.safeargs.kotlin")
	id("com.strv.mlyko.kitchensink")
}

android {
	buildFeatures {
		dataBinding = true
	}
}

dependencies {
	implementation(project(":core"))
	implementation(Depends.DI.dagger)
	kapt(Depends.DI.daggerCompiler)
	kapt(Depends.DI.daggerAnnotationProcessor)
}