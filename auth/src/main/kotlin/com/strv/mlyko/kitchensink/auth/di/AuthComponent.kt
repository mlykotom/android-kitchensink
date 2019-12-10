package com.strv.mlyko.kitchensink.auth.di

import android.content.Context
import com.strv.mlyko.kitchensink.auth.presentation.AuthActivity
import com.strv.mlyko.kitchensink.common.di.FeatureScope
import com.strv.mlyko.kitchensink.di.AppComponent
import com.strv.mlyko.kitchensink.domain.KitchenSinkApp
import dagger.Component

@Component(
	dependencies = [
		AppComponent::class
	],
	modules = [
		AuthUiBuilderModule::class
	]
)
@FeatureScope
interface AuthComponent {
	@Component.Factory
	interface Factory {
		fun create(
			appComponent: AppComponent
		): AuthComponent
	}

	fun inject(a: AuthActivity)
}


interface FeatureModule{
	fun install(context: Context)
}

fun install(context:Context){

}
