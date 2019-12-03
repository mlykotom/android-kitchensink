package com.strv.mlyko.kitchensink.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import com.strv.mlyko.kitchensink.KitchenSinkApp
import com.strv.mlyko.kitchensink.ui.auth.AuthFragment
import com.strv.mlyko.kitchensink.ui.auth.AuthViewModel
import com.strv.mlyko.kitchensink.ui.auth.login.AuthLoginFragment
import com.strv.mlyko.kitchensink.ui.auth.register.AuthRegisterFragment
import com.strv.mlyko.kitchensink.ui.main.MainActivity
import com.strv.mlyko.kitchensink.ui.main.MainFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Component(
	modules = [
		CommonAppModule::class,
		AppUiBuilderModule::class
	]
)
@Singleton
interface AppComponent {
	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance
			application: Application
		): AppComponent
	}

	fun context(): Context
	fun application(): Application
	fun sharedPrefs(): SharedPreferences

	fun inject(app: KitchenSinkApp)
	fun inject(mainActivity: MainActivity)
}

@Module
object CommonAppModule {
	@Provides
	fun provideAppContext(application: Application): Context = application.applicationContext

	@Provides
	fun provideSharedPreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}

@Module
abstract class AppUiBuilderModule {
	@Binds
	@IntoMap
	@FragmentKey(MainFragment::class)
	abstract fun contributeMainFragment(frag: MainFragment): Fragment

	@Binds
	@IntoMap
	@FragmentKey(AuthFragment::class)
	abstract fun contributeAuthFragment(frag: AuthFragment): Fragment

	@Binds
	@IntoMap
	@ViewModelKey(AuthViewModel::class)
	abstract fun contributeAuthViewModel(frag: AuthViewModel): ViewModel

	@Binds
	@IntoMap
	@FragmentKey(AuthLoginFragment::class)
	abstract fun contributeAuthLoginFragment(frag: AuthLoginFragment): Fragment

	@Binds
	@IntoMap
	@FragmentKey(AuthRegisterFragment::class)
	abstract fun contributeAuthRegisterFragment(frag: AuthRegisterFragment): Fragment
}