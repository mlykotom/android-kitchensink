package com.strv.mlyko.kitchensink.common.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.strv.mlyko.kitchensink.features.Feature
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FeatureKey(val value: KClass<out Feature<*>>)
