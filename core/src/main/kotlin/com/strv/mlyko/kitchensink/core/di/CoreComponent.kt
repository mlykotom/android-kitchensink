package com.strv.mlyko.kitchensink.core.di

import dagger.Component

@Component
interface CoreComponent {
	@Component.Factory
	interface Factory {
		fun create(): CoreComponent
	}
}