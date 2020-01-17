package com.strv.mlyko.kitchensink.common.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<T : ViewModel> {
	fun create(savedStateHandle: SavedStateHandle): T
}
