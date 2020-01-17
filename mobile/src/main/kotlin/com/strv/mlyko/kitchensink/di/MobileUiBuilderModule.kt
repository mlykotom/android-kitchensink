package com.strv.mlyko.kitchensink.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.strv.mlyko.kitchensink.common.di.FragmentKey
import com.strv.mlyko.kitchensink.common.di.ViewModelAssistedFactory
import com.strv.mlyko.kitchensink.common.di.ViewModelKey
import com.strv.mlyko.kitchensink.presentation.main.MainFragment
import com.strv.mlyko.kitchensink.presentation.main.MainViewModel
import com.strv.mlyko.kitchensink.presentation.main.MyDialog
import com.strv.mlyko.kitchensink.presentation.test.TestFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds

@AssistedModule
@Module(includes = [
	AssistedInject_MobileUiBuilderModule::class
])
abstract class MobileUiBuilderModule {
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
	@FragmentKey(TestFragment::class)
	abstract fun contributeTestFragment(frag: TestFragment): Fragment

	@Binds
	@IntoMap
	@FragmentKey(MyDialog::class)
	abstract fun contributeMyDialog(frag: MyDialog): Fragment
}
