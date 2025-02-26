package com.strv.mlyko.kitchensink.common.di

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.MembersInjector
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider

@Reusable
open class InjectingSavedStateViewModelFactory @Inject constructor(
	val assistedFactories: Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModelAssistedFactory<out ViewModel>>,
	val viewModelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) {
	/**
	 * Creates instance of ViewModel either annotated with @AssistedInject or @Inject and passes dependencies it needs.
	 */
	fun create(owner: SavedStateRegistryOwner, defaultArgs: Bundle? = null) =
		object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
			override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
				val viewModel = createAssistedInjectViewModel(modelClass, handle)
					?: createInjectViewModel(modelClass, handle)
					?: throw IllegalArgumentException("Unknown model class $modelClass")

				try {
					@Suppress("UNCHECKED_CAST")
					return viewModel as T
				} catch (e: Exception) {
					throw RuntimeException(e)
				}
			}
		}

	/**
	 * Creates ViewModel based on @AssistedInject constructor and its factory
	 */
	private fun <T : ViewModel?> createAssistedInjectViewModel(modelClass: Class<T>, handle: SavedStateHandle): ViewModel? {
		val creator = assistedFactories[modelClass]
			?: assistedFactories.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
			?: return null

		return creator.create(handle)
	}

	/**
	 * Creates ViewModel based on regular Dagger @Inject constructor
	 */
	private fun <T : ViewModel?> createInjectViewModel(modelClass: Class<T>, handle: SavedStateHandle): ViewModel? {
		val creator = viewModelProviders[modelClass]
			?: viewModelProviders.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
			?: return null

		return creator.get()
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
