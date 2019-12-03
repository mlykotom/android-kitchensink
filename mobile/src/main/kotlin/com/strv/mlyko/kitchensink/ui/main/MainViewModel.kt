package com.strv.mlyko.kitchensink.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.strv.mlyko.kitchensink.arch.events.SingleLiveEvent

private const val KEY_STATE_COUNTER = "KEY_STATE_COUNTER"

class MainViewModel(
	private val savedStateHandle: SavedStateHandle
) : ViewModel() {

	val displayMessage = SingleLiveEvent<String>()

	val counter = MutableLiveData<Int>(savedStateHandle.get(KEY_STATE_COUNTER) ?: 0)

	init {
		counter.observeForever {
			savedStateHandle.set(KEY_STATE_COUNTER, it)
		}
	}

	fun onPlusClick() {
		counter.value = (counter.value ?: 0) + 1
		displayMessage.value = "New counter value is ${counter.value}"
	}
}