package com.strv.mlyko.kitchensink.presentation.main

import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.arch.BaseHostActivity
import com.strv.mlyko.kitchensink.domain.appComponent

class MainActivity : BaseHostActivity(R.navigation.navigation_main) {
	override fun injectHere() {
		appComponent.inject(this)
	}
}
