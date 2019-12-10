package com.strv.mlyko.kitchensink.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.strv.mlyko.kitchensink.domain.AppVersion
import com.strv.mlyko.kitchensink.domain.KitchenSinkApp
import com.strv.mlyko.kitchensink.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
	modules = [
		CommonAppModule::class,
		AppUiBuilderModule::class
	]
)
@Singleton
interface AppComponent {
	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance
			application: Application,
			@BindsInstance
			appVersion: AppVersion
		): AppComponent
	}

	fun context(): Context
	fun application(): Application
	fun sharedPrefs(): SharedPreferences

	fun appVersion(): AppVersion

	fun inject(app: KitchenSinkApp)
	fun inject(activity: MainActivity)
}

