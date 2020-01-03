package com.strv.mlyko.kitchensink.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.strv.mlyko.kitchensink.common.di.DaggerLazy
import com.strv.mlyko.kitchensink.common.domain.AppVersion
import com.strv.mlyko.kitchensink.domain.KitchenSinkApp
import com.strv.mlyko.kitchensink.features.AuthFeature
import com.strv.mlyko.kitchensink.features.Feature
import com.strv.mlyko.kitchensink.features.requireFeature
import com.strv.mlyko.kitchensink.presentation.main.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Component(
	modules = [
		CommonAppModule::class,
		FeaturesModule::class,
		MobileUiBuilderModule::class
	]
)
@Singleton
interface AppComponent : AuthFeature.Dependencies {
	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance
			application: Application,
			@BindsInstance
			appVersion: AppVersion
		): AppComponent
	}

	fun authFeature(): DaggerLazy<AuthFeature>

	fun context(): Context
	fun application(): Application
	fun sharedPrefs(): SharedPreferences

	fun appVersion(): AppVersion

	fun inject(app: KitchenSinkApp)
	fun inject(activity: MainActivity)
}

@Module
object FeaturesModule {
	@Provides
	@Singleton
	fun provideAuthFeature(appComponent: AppComponent): AuthFeature {
		return requireFeature<AuthFeature, AuthFeature.Dependencies>(appComponent)
	}

	@Module
	abstract class Binders {
		@Binds
		@IntoSet
		abstract fun bindAuthFeatureToFeatures(f: AuthFeature): Feature<*>
	}
}
