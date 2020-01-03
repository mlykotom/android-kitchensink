package com.strv.mlyko.kitchensink.features

import android.content.Context
import androidx.fragment.app.Fragment
import javax.inject.Provider

interface AuthFeature : Feature<AuthFeature.Dependencies> {
	interface Dependencies : FeatureDependencies {
		val appContext: Context
	}
}
