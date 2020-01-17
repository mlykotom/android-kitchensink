package com.strv.mlyko.kitchensink.auth.di

import android.content.Context
import android.content.Intent
import androidx.annotation.Keep
import androidx.navigation.NavController
import com.google.auto.service.AutoService
import com.strv.mlyko.kitchensink.auth.R
import com.strv.mlyko.kitchensink.domain.appComponent
import com.strv.mlyko.kitchensink.features.AuthFeature

internal var authComponent: AuthComponent? = null
	private set

@Suppress("unused")
@Keep
@AutoService(AuthFeature::class)
class AuthFeatureImpl : AuthFeature {
	override fun inject(dependencies: AuthFeature.Dependencies) {
		if (authComponent != null) return

		authComponent = DaggerAuthComponent
			.factory()
			.create(dependencies.appContext.appComponent)
	}

	override fun getLaunchIntent(context: Context): Intent = TODO()// Intent(context, AuthActivity::class.java)

	override val navGraph: Int = R.navigation.navigation_auth

	override fun initialize(navController: NavController) {
		val navGraph = navController.navInflater.inflate(R.navigation.navigation_auth)
		navController.graph.addDestination(navGraph)
	}

	override val featureFragments get() = authComponent!!.getMapOfClassAndFragmentProvider()
}
