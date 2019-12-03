object Versions {
	const val compileSdkVersion = 29
	const val minSdkVersion = 21
	const val targetSdkVersion = compileSdkVersion

	const val androidGradle = "4.0.0-alpha04"
	const val kotlin = "1.3.61"

	const val androidxAppcompat = "1.1.0"
	const val androidxCore = "1.2.0-rc01"
	const val androidxCoreTesting = "2.1.0"
	const val androidxLifecycle = "2.2.0-rc02"
	const val androidxLifecycleSavedStated = "1.0.0-rc02"
	const val androidxConstraintLayout = "2.0.0-beta3"
	const val androidxNavigation = "2.2.0-rc02"
	const val androidxViewPager2 = "1.0.0"

	const val materialComponents = "1.1.0-beta02"

	const val dagger = "2.25.2"
}

object Depends {
	object Classpath {
		const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
		const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
		const val androidxNavigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidxNavigation}"
	}

	object Kotlin {
		const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
	}

	object AndroidX {
		const val appcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
		const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"

		object Lifecycle {
			const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
			const val common = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
			const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidxLifecycleSavedStated}"
		}

		const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
		const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.androidxViewPager2}"

		const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
		const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
	}

	object Google {
		const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
	}

	object DI {
		const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
		const val daggerAndroid = "com.google.dagger:dagger-android-support:${Versions.dagger}"
		const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
		const val daggerAnnotationProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
	}
}

object TestDepends {
	const val junit = "junit:junit:4.12"
	const val androidxCoreTesting = "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"
}
