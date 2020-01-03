package com.strv.mlyko.kitchensink.domain

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.strv.mlyko.kitchensink.BuildConfig
import com.strv.mlyko.kitchensink.common.domain.AppVersion
import com.strv.mlyko.kitchensink.di.AppComponent
import com.strv.mlyko.kitchensink.di.DaggerAppComponent
import com.strv.mlyko.kitchensink.features.AuthFeature

class KitchenSinkApp : Application(), AuthFeature.Dependencies {
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

	override val appContext: Context = this
}

val Activity.appComponent get() = KitchenSinkApp.appComponent(this)
val Fragment.appComponent get() = KitchenSinkApp.appComponent(requireActivity())

val Context.appComponent get() = KitchenSinkApp.appComponent(this)
