package com.strv.mlyko.kitchensink.features

import android.content.Context
import android.content.Intent
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import javax.inject.Provider

interface Feature<T : FeatureDependencies> {
	val featureFragments: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>

	fun getLaunchIntent(context: Context): Intent
	fun inject(dependencies: T)
	fun initialize(navController: NavController)

//	@NavigationRes
	val navGraph: Int
}

interface FeatureDependencies

