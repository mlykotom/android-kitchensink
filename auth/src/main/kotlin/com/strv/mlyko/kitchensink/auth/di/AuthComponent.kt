package com.strv.mlyko.kitchensink.auth.di

import com.strv.mlyko.kitchensink.core.di.FeatureScope
import dagger.Component

@Component(
	dependencies = [
	]
)
@FeatureScope
interface AuthComponent {
	@Component.Factory
	interface Factory {
		fun create(): AuthComponent
	}
}