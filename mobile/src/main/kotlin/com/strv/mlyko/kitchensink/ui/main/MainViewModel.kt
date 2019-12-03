package com.strv.mlyko.kitchensink.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val KEY_STATE_COUNTER = "KEY_STATE_COUNTER"

class MainViewModel(
	private val savedStateHandle: SavedStateHandle
) : ViewModel() {

	val counter = savedStateHandle.getLiveData(KEY_STATE_COUNTER, 0)

	override fun onCleared() {
		super.onCleared()
		savedStateHandle.set(KEY_STATE_COUNTER, counter.value ?: 0)
	}

	fun onPlusClick() {
		counter.value = (counter.value ?: 0) + 1
	}
}