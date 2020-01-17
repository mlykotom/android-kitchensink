package com.strv.mlyko.kitchensink.presentation.main

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.arch.BaseViewModel
import com.strv.mlyko.kitchensink.arch.events.SingleLiveEvent
import com.strv.mlyko.kitchensink.common.di.ViewModelAssistedFactory
import com.strv.mlyko.kitchensink.common.domain.AppVersion
import com.strv.mlyko.kitchensink.common.domain.manager.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val KEY_STATE_COUNTER = "KEY_STATE_COUNTER"

class MainViewModel @AssistedInject constructor(
	private val sharedPrefs: SharedPreferences,
	private val appContext: Context,
	private val appVersion: AppVersion,
	@Assisted private val savedStateHandle: SavedStateHandle,
	private val userManager: UserManager
) : BaseViewModel() {
	@AssistedInject.Factory
	interface Factory : ViewModelAssistedFactory<MainViewModel> {
		override fun create(savedStateHandle: SavedStateHandle): MainViewModel
	}

	val displayMessage = SingleLiveEvent<String>()

	val counter = MutableLiveData<Int>(0)

	val isUserLoggedIn = MutableLiveData(userManager.isUserLoggedIn.valueOrNull ?: false)

	init {
		Log.d("MainViewModel", sharedPrefs.getInt("counter", -1).toString())

		counter.value = savedStateHandle.get(KEY_STATE_COUNTER) ?: 0
		counter.observeForever {
			savedStateHandle.set(KEY_STATE_COUNTER, it)
		}

		viewModelScope.launch {

			userManager.isUserLoggedIn.consumeEach {
				Log.d("MAIN_VM", it.toString())
				withContext(Dispatchers.Main) {
					isUserLoggedIn.value = it
				}
			}
		}
	}

	fun onLogoutClick() {
		userManager.logUser(false)
	}

	fun onPlusClick() {
		counter.value = (counter.value ?: 0) + 1
		sharedPrefs.edit().putInt("counter", counter.value ?: 0).apply()
		displayMessage.value = "New counter value is ${counter.value}"
	}
}
