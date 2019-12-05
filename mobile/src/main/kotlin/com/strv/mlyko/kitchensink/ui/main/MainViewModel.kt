package com.strv.mlyko.kitchensink.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.AppVersion
import com.strv.mlyko.kitchensink.arch.BaseViewModel
import com.strv.mlyko.kitchensink.arch.events.SingleLiveEvent
import com.strv.mlyko.kitchensink.di.ViewModelAssistedFactory

const val KEY_STATE_COUNTER = "KEY_STATE_COUNTER"

class MainViewModel @AssistedInject constructor(
	private val sharedPrefs: SharedPreferences,
	@Assisted private val savedStateHandle: SavedStateHandle,
	private val appContext: Context,
	private val appVersion: AppVersion
) : BaseViewModel() {
	@AssistedInject.Factory
	interface Factory : ViewModelAssistedFactory<MainViewModel> {
		override fun create(savedStateHandle: SavedStateHandle): MainViewModel
	}

	val displayMessage = SingleLiveEvent<String>()

	val counter = MutableLiveData<Int>(0)

	init {
		Log.d("MainViewModel", sharedPrefs.getInt("counter", -1).toString())

		counter.value = savedStateHandle.get(KEY_STATE_COUNTER) ?: 0
		counter.observeForever {
			savedStateHandle.set(KEY_STATE_COUNTER, it)
		}
	}

	fun onPlusClick() {
		counter.value = (counter.value ?: 0) + 1
		sharedPrefs.edit().putInt("counter", counter.value ?: 0).apply()
		displayMessage.value = "New counter value is ${counter.value}"
	}
}