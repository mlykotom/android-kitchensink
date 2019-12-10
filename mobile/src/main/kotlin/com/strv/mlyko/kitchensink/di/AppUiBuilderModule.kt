package com.strv.mlyko.kitchensink.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.strv.mlyko.kitchensink.common.di.CommonUiModule
import com.strv.mlyko.kitchensink.common.di.FragmentKey
import com.strv.mlyko.kitchensink.common.di.ViewModelAssistedFactory
import com.strv.mlyko.kitchensink.common.di.ViewModelKey
import com.strv.mlyko.kitchensink.presentation.main.MainFragment
import com.strv.mlyko.kitchensink.presentation.main.MainViewModel
import com.strv.mlyko.kitchensink.presentation.main.MyDialog
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [
	CommonUiModule::class,
	AssistedInject_AppUiBuilderModule::class
])
abstract class AppUiBuilderModule {
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
}
