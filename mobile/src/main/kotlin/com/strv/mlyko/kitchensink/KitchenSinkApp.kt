package com.strv.mlyko.kitchensink

import android.app.Application
import com.strv.mlyko.kitchensink.di.DaggerAppComponent

class KitchenSinkApp : Application() {
	val appComponent by lazy {
		DaggerAppComponent.factory().create(this)
	}

	override fun onCreate() {
		super.onCreate()
		appComponent.inject(this)
	}
}

