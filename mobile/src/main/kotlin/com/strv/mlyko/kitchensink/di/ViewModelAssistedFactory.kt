package com.strv.mlyko.kitchensink.di

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

interface ViewModelAssistedFactory<T : ViewModel> {
	fun create(savedStateHandle: SavedStateHandle): T
}

/**
 * TODO: probably cannot be singleton, because not working with multiple scopes
 */
@Singleton
class InjectingSavedStateViewModelFactory @Inject constructor(
	private val assistedCreators: MutableMap<Class<out ViewModel>, ViewModelAssistedFactory<out ViewModel>>,
	private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
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
			// attempt assisted inject
			val assistedCreator = assistedCreators[modelClass]
			if (assistedCreator != null) {
				try {
					return assistedCreator.create(handle) as T
				} catch (e: Exception) {
					throw RuntimeException(e)
				}
			}

			// otherwise attempt to do normal inject
			var creator: Provider<out ViewModel>? = creators[modelClass]
			if (creator == null) {
				// TODO kotlinify
				for ((vmClass, value) in creators) {
					if (modelClass.isAssignableFrom(vmClass)) {
						creator = value
						break
					}
				}
			}

			if (creator == null) {
				throw IllegalArgumentException("Unknown model class $modelClass")
			}

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