object Versions {
	const val compileSdkVersion = 29
	const val minSdkVersion = 21
	const val targetSdkVersion = compileSdkVersion

	// WARNING: has to be changed in buildSrc/build.gradle.kts as well
	const val androidGradle = "4.0.0-alpha07"
	const val kotlin = "1.3.61"

	const val androidxAppcompat = "1.1.0"
	const val androidxCore = "1.2.0-rc01"
	const val androidxCoreTesting = "2.1.0"
	const val androidxLifecycle = "2.2.0-rc03"
	const val androidxLifecycleSavedStated = "1.0.0-rc03"
	const val androidxConstraintLayout = "2.0.0-beta3"
	const val androidxNavigation = "2.2.0-rc04"
	const val androidxViewPager2 = "1.0.0"
	const val androidxPreferences = "1.1.0"
	const val androidXfragment = "1.2.0-rc03"

	const val materialComponents = "1.1.0-beta02"

	const val dagger = "2.25.4"
	const val assistedInject = "0.5.2"

	const val leakCanary = "2.0"

	const val autoService = "1.0-rc6"
}

/**
 *
 */
object Depends {
	object Classpath {
		const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
		const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
		const val androidxNavigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidxNavigation}"
	}

	object Kotlin {
		const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
	}

	object AndroidX {
		const val appcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
		const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
		const val preferences = "androidx.preference:preference-ktx:${Versions.androidxPreferences}"

		object Lifecycle {
			const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
			const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
			const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
			const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
			const val common = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
			const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidxLifecycleSavedStated}"
			const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
		}

		const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.androidXfragment}"

		const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
		const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.androidxViewPager2}"

		const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
//		const val navigationFragment = "androidx.navigation:navigation-dynamic-features-fragment:2.3.0-SNAPSHOT"
		const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
	}

	object Google {
		const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
	}

	object AutoService {
		const val annotations = "com.google.auto.service:auto-service-annotations:${Versions.autoService}"
		const val processor = "com.google.auto.service:auto-service:${Versions.autoService}"
	}

	object DI {
		const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
		const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
		const val daggerAnnotationProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

		object Assisted {
			const val annotations = "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.assistedInject}"
			const val processor = "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.assistedInject}"
		}
	}
}

object DebugDepends {
	const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}

object TestDepends {
	const val junit = "junit:junit:4.12"
	const val androidxCoreTesting = "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"
}
