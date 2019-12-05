package com.strv.mlyko.kitchensink.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.strv.mlyko.kitchensink.AppVersion
import com.strv.mlyko.kitchensink.KitchenSinkApp
import com.strv.mlyko.kitchensink.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
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

@Module
object CommonAppModule {
	@Provides
	fun provideAppContext(application: Application): Context = application.applicationContext

	@Provides
	fun provideSharedPreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}

