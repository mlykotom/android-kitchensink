package com.strv.mlyko.kitchensink.auth.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.strv.mlyko.kitchensink.auth.presentation.AuthFragment
import com.strv.mlyko.kitchensink.auth.presentation.AuthWholeViewModel
import com.strv.mlyko.kitchensink.auth.presentation.login.AuthLoginFragment
import com.strv.mlyko.kitchensink.auth.presentation.register.AuthRegisterFragment
import com.strv.mlyko.kitchensink.common.di.CommonUiModule
import com.strv.mlyko.kitchensink.common.di.FragmentKey
import com.strv.mlyko.kitchensink.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(
	includes = [
		CommonUiModule::class,
		AssistedInject_AuthUiBuilderModule::class
	]
)
abstract class AuthUiBuilderModule {
	@Binds
	@IntoMap
	@FragmentKey(AuthFragment::class)
	abstract fun contributeAuthFragment(frag: AuthFragment): Fragment

	@Binds
	@IntoMap
	@ViewModelKey(AuthWholeViewModel::class)
	abstract fun contributeAuthWholeViewModel(vm: AuthWholeViewModel): ViewModel

	@Binds
	@IntoMap
	@FragmentKey(AuthLoginFragment::class)
	abstract fun contributeAuthLoginFragment(frag: AuthLoginFragment): Fragment

	@Binds
	@IntoMap
	@FragmentKey(AuthRegisterFragment::class)
	abstract fun contributeAuthRegisterFragment(frag: AuthRegisterFragment): Fragment
}
