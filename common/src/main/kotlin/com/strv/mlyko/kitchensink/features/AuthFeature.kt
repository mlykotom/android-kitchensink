package com.strv.mlyko.kitchensink.features

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import javax.inject.Provider

interface AuthFeature : Feature<AuthFeature.Dependencies> {
	interface Dependencies : FeatureDependencies {
		val sharedPreferences: SharedPreferences
		val appContext: Context
	}
}
