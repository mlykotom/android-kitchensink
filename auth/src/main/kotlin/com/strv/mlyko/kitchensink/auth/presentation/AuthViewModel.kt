package com.strv.mlyko.kitchensink.auth.presentation

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.arch.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthViewModel @AssistedInject constructor(
	private val appContext: Context,
	@Assisted private val savedStateHandle: SavedStateHandle,
	@Assisted private val authWholeViewModel: AuthWholeViewModel,
	@Assisted private val userId: String
) : BaseViewModel() {
	@AssistedInject.Factory
	interface Factory {
		fun create(
			savedStateHandle: SavedStateHandle,
			authWholeViewModel: AuthWholeViewModel,
			userId: String
		): AuthViewModel
	}

	val authCounter = savedStateHandle.getLiveData<Int>("authCounter", 0)
//	val authCounter = MutableLiveData<Int>(0)

	override fun onCreate(owner: LifecycleOwner) {
		authWholeViewModel.currentFragment = this::class.java.simpleName
	}

	suspend fun delayedIncrement() {
		withContext(Dispatchers.Default) {
			authCounter.postValue(authCounter.value!! + 1)
			delay(1000)
		}
		delayedIncrement()
	}

	init {
		Log.d("asdfghjk", appContext.getString(R.string.app_name))
		Log.d("asdfghjk", userId)

		viewModelScope.launch {
			delayedIncrement()
			Log.d("bnana", "banan")
		}
	}

	fun onRegisterClick() {
		navigate(AuthFragmentDirections.actionAuthFragmentToAuthRegisterFragment())
	}

	fun onLoginClick() {
		navigate(AuthFragmentDirections.actionAuthFragmentToAuthLoginFragment())
	}
}
