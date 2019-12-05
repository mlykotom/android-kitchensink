package com.strv.mlyko.kitchensink.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.strv.mlyko.kitchensink.ui.auth.AuthFragment
import com.strv.mlyko.kitchensink.ui.auth.AuthViewModel
import com.strv.mlyko.kitchensink.ui.auth.login.AuthLoginFragment
import com.strv.mlyko.kitchensink.ui.auth.register.AuthRegisterFragment
import com.strv.mlyko.kitchensink.ui.main.MainFragment
import com.strv.mlyko.kitchensink.ui.main.MainViewModel
import com.strv.mlyko.kitchensink.ui.main.MyDialog
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds
import javax.inject.Provider

@AssistedModule
@Module(includes = [AssistedInject_AppUiBuilderModule::class])
abstract class AppUiBuilderModule {
	@Multibinds
	abstract fun fragments(): Map<Class<out Fragment>, @JvmSuppressWildcards Fragment>
	@Multibinds
	abstract fun viewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>
	@Multibinds
	abstract fun assistedViewModels(): MutableMap<Class<out ViewModel>, ViewModelAssistedFactory<out ViewModel>>

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