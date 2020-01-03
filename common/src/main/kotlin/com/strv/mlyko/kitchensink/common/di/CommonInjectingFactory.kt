package com.strv.mlyko.kitchensink.common.di

import androidx.fragment.app.Fragment
import com.strv.mlyko.kitchensink.features.AuthFeature
import javax.inject.Inject
import javax.inject.Provider

// TODO should be only internal??
class CommonInjectingFactory @Inject constructor(
	creators: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>,
	authFeature: AuthFeature
//	features: Set<@JvmSuppressWildcards Provider<Feature<*>>>
) : InjectingFragmentFactory(creators + authFeature.featureFragments)

//private fun transformFeaturesToFragments(features: Set<Provider<Feature<*>>>): Map<Class<out Fragment>, Provider<Fragment>> = features
//	.asSequence()
//	.flatMap { it.get().featureFragments.asSequence() }
//	.associate { it.key to it.value }

