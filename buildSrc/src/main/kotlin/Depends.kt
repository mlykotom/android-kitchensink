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
}

object ClasspathDepends {
	const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
	const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
	const val androidxNavigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidxNavigation}"
}

object Depends {
	const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

	const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
	const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"

	const val androidxLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
	const val androidxLifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
	const val androidxLifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidxLifecycleSavedStated}"

	const val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
	const val androidxNavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
	const val androidxNavigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
	const val androidxViewPager2 = "androidx.viewpager2:viewpager2:${Versions.androidxViewPager2}"

	const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"

}

object TestDepends {
	const val junit = "junit:junit:4.12"
	const val androidxCoreTesting = "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"
}
