package com.strv.mlyko.kitchensink.core.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.strv.mlyko.kitchensink.presentation.auth.AuthFragment
import com.strv.mlyko.kitchensink.presentation.auth.AuthWholeViewModel
import com.strv.mlyko.kitchensink.presentation.auth.login.AuthLoginFragment
import com.strv.mlyko.kitchensink.presentation.auth.register.AuthRegisterFragment
import com.strv.mlyko.kitchensink.presentation.main.MainFragment
import com.strv.mlyko.kitchensink.presentation.main.MainViewModel
import com.strv.mlyko.kitchensink.presentation.main.MyDialog
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds

@AssistedModule
@Module(includes = [AssistedInject_AppUiBuilderModule::class])
abstract class AppUiBuilderModule {
	@Multibinds
	abstract fun fragments(): Map<Class<out Fragment>, @JvmSuppressWildcards Fragment>

	@Multibinds
	abstract fun viewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

	@Multibinds
	abstract fun assistedViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModelAssistedFactory<out ViewModel>>

	@Binds
	@IntoMap
	@FragmentKey(MainFragment::class)
	abstract fun contributeMainFragment(frag: MainFragment): Fragment

	@Binds
	@IntoMap
	@ViewModelKey(MainViewModel::class)
	abstract fun bindMainViewModelFactory(factory: MainViewModel.Factory): ViewModelAssistedFactory<out ViewModel>

	@Binds
	@IntoMap
	@FragmentKey(MyDialog::class)
	abstract fun contributeMyDialog(frag: MyDialog): Fragment

	@Binds
	@IntoMap
	@FragmentKey(AuthFragment::class)
	abstract fun contributeAuthFragment(frag: AuthFragment): Fragment

//	@Binds
//	@IntoMap
//	@ViewModelKey(AuthViewModel::class)
//	abstract fun contributeAuthViewModel(frag: AuthViewModel): ViewModel

	@Binds
	@IntoMap
	@ViewModelKey(AuthWholeViewModel::class)
	abstract fun contributeAuthWholeViewModel(vm: AuthWholeViewModel): ViewModel

//	@Binds
//	@IntoMap
//	@ViewModelKey(AuthViewModel::class)
//	abstract fun contributeAuthViewModel(factory: AuthViewModel.Factory): ViewModelAssistedFactory<out ViewModel>

	@Binds
	@IntoMap
	@FragmentKey(AuthLoginFragment::class)
	abstract fun contributeAuthLoginFragment(frag: AuthLoginFragment): Fragment

	@Binds
	@IntoMap
	@FragmentKey(AuthRegisterFragment::class)
	abstract fun contributeAuthRegisterFragment(frag: AuthRegisterFragment): Fragment
}