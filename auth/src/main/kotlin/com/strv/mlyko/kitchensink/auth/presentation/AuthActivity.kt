package com.strv.mlyko.kitchensink.auth.presentation

import com.strv.mlyko.kitchensink.arch.BaseHostActivity
import com.strv.mlyko.kitchensink.auth.R
import com.strv.mlyko.kitchensink.auth.di.DaggerAuthComponent
import com.strv.mlyko.kitchensink.domain.appComponent

class AuthActivity : BaseHostActivity(R.navigation.navigation_auth) {
	override fun injectHere() {
		DaggerAuthComponent.factory().create(appComponent).inject(this)
	}
}
