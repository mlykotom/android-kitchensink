package com.strv.mlyko.kitchensink.domain

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.NavGraph
import com.strv.mlyko.kitchensink.BuildConfig
import com.strv.mlyko.kitchensink.di.AppComponent
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

	companion object {
		@JvmStatic
		fun appComponent(context: Context): AppComponent = (context.applicationContext as KitchenSinkApp).appComponent
	}
}

val Activity.appComponent get() = KitchenSinkApp.appComponent(this)
val Fragment.appComponent get() = KitchenSinkApp.appComponent(requireActivity())
