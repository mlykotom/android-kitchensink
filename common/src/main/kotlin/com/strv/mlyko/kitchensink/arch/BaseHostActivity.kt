package com.strv.mlyko.kitchensink.arch

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.strv.mlyko.kitchensink.common.R
import com.strv.mlyko.kitchensink.common.di.InjectingFragmentFactory
import javax.inject.Inject

abstract class BaseHostActivity(
	@NavigationRes
	private val navigationGraph: Int
) : AppCompatActivity(R.layout.activity_empty) {
	@Inject
	lateinit var injectingFragmentFactory: InjectingFragmentFactory

	abstract fun injectHere()

	override fun onCreate(savedInstanceState: Bundle?) {
		injectHere()
		supportFragmentManager.fragmentFactory = injectingFragmentFactory
		super.onCreate(savedInstanceState)

		if (savedInstanceState == null) {
			val navHostFragment = NavHostFragment.create(navigationGraph)
			supportFragmentManager.beginTransaction()
				.replace(R.id.main_container, navHostFragment)
				.setPrimaryNavigationFragment(navHostFragment)
				.commit()
		}
	}
}
