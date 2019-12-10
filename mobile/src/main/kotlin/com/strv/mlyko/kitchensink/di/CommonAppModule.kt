package com.strv.mlyko.kitchensink.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides

@Module
internal object CommonAppModule {
	@Provides
	fun provideAppContext(application: Application): Context = application.applicationContext

	@Provides
	fun provideSharedPreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}
