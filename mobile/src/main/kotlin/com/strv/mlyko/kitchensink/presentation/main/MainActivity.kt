package com.strv.mlyko.kitchensink.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.common.di.CommonInjectingFactory
import com.strv.mlyko.kitchensink.domain.appComponent
import com.strv.mlyko.kitchensink.features.AuthFeature
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
	@Inject
	lateinit var injectingFragmentFactory: CommonInjectingFactory

	@Inject
	lateinit var authFeature: AuthFeature

	override fun onCreate(savedInstanceState: Bundle?) {
		appComponent.inject(this)
		supportFragmentManager.fragmentFactory = injectingFragmentFactory
		super.onCreate(savedInstanceState)

		val navController = findNavController(R.id.nav_host_fragment)

		val mainGraph = navController.navInflater.inflate(R.navigation.navigation_main)
		val testGraph = navController.navInflater.inflate(R.navigation.navigation_test)
		mainGraph.addDestination(testGraph)

		val authGraph = navController.navInflater.inflate(authFeature.navGraph)
		mainGraph.addDestination(authGraph)

		navController.graph = mainGraph
	}
}

