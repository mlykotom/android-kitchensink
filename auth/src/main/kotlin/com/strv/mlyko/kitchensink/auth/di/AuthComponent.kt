package com.strv.mlyko.kitchensink.auth.di

import androidx.fragment.app.Fragment
import com.strv.mlyko.kitchensink.common.di.FeatureScope
import com.strv.mlyko.kitchensink.features.AuthFeature
import dagger.Component
import dagger.Module
import javax.inject.Provider
import javax.inject.Singleton

@Component(
	dependencies = [
		AuthFeature.Dependencies::class
	],
	modules = [
		AuthModule::class,
		AuthUiBuilderModule::class
	]
)
//@FeatureScope
@Singleton
interface AuthComponent {
	@Component.Factory
	interface Factory {
		fun create(dependencies: AuthFeature.Dependencies): AuthComponent
	}

	fun getMapOfClassAndFragmentProvider(): Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
}

@Module
internal object AuthModule {

}
