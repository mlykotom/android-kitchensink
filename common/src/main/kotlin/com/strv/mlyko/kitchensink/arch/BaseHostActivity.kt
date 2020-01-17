package com.strv.mlyko.kitchensink.arch

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.strv.mlyko.kitchensink.common.R
import com.strv.mlyko.kitchensink.common.di.CommonInjectingFactory
import javax.inject.Inject

abstract class BaseHostActivity(
	@NavigationRes
	protected val navigationGraph: Int
) : AppCompatActivity(R.layout.activity_empty) {
	@Inject
	internal lateinit var injectingFragmentFactory: CommonInjectingFactory

	abstract fun injectHere()

	protected open fun createNavHostFragment() = NavHostFragment.create(navigationGraph)

	override fun onCreate(savedInstanceState: Bundle?) {
		injectHere()
		supportFragmentManager.fragmentFactory = injectingFragmentFactory
		super.onCreate(savedInstanceState)

		if (savedInstanceState == null) {
			val navHostFragment = createNavHostFragment()

			supportFragmentManager.beginTransaction()
				.replace(R.id.main_container, navHostFragment, "main_nav_host")
				.setPrimaryNavigationFragment(navHostFragment)
				.commit()
		}
	}
}
