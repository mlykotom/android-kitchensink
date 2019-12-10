package com.strv.mlyko.kitchensink.common.di

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider

interface ViewModelAssistedFactory<T : ViewModel> {
	fun create(savedStateHandle: SavedStateHandle): T
}

@Reusable
class InjectingSavedStateViewModelFactory @Inject constructor(
	private val assistedFactories: Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModelAssistedFactory<out ViewModel>>,
	private val viewModelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) {
	fun create(
		owner: SavedStateRegistryOwner,
		defaultArgs: Bundle? = null
	) = object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
		@Suppress("UNCHECKED_CAST")
		override fun <T : ViewModel?> create(
			key: String,
			modelClass: Class<T>,
			handle: SavedStateHandle
		): T {
			// Attempt to get ViewModel from assisted inject factories
			assistedFactories[modelClass]?.let {
				try {
					return it.create(handle) as T
				} catch (e: Exception) {
					throw RuntimeException(e)
				}
			}

			// If ViewModel not found among assisted factories, attempt regular dagger injection
			val creator = viewModelProviders[modelClass]
				?: viewModelProviders.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
				?: throw IllegalArgumentException("Unknown model class $modelClass")

			try {
				return creator.get() as T
			} catch (e: Exception) {
				throw RuntimeException(e)
			}
		}
	}
}

fun createCustomFactory(
	owner: SavedStateRegistryOwner,
	defaultArgs: Bundle? = null,
	factoryCreator: (handle: SavedStateHandle) -> ViewModel
) = object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
	override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
		@Suppress("UNCHECKED_CAST")
		return factoryCreator(handle) as T
	}
}
