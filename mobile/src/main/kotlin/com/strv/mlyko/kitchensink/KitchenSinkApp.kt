package com.strv.mlyko.kitchensink

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.strv.mlyko.kitchensink.di.DaggerAppComponent

class KitchenSinkApp : Application() {
	val appComponent by lazy {
		DaggerAppComponent.factory().create(
			this,
			AppVersion(BuildConfig.VERSION_CODE, BuildConfig.VERSION_NAME)
		)
	}

	override fun onCreate() {
		super.onCreate()
		appComponent.inject(this)
	}
}

val Activity.appComponent get() = (application as KitchenSinkApp).appComponent
val Fragment.appComponent get() = (requireActivity().application as KitchenSinkApp).appComponent

