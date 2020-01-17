package com.strv.mlyko.kitchensink.common.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.multibindings.Multibinds

@Module
abstract class CommonUiModule {
	@Multibinds
	abstract fun fragments(): Map<Class<out Fragment>, @JvmSuppressWildcards Fragment>

	@Multibinds
	abstract fun viewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

	@Multibinds
	abstract fun assistedViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModelAssistedFactory<out ViewModel>>
}
