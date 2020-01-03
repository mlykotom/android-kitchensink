package com.strv.mlyko.kitchensink.auth.presentation.login

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.arch.BaseViewModel
import com.strv.mlyko.kitchensink.auth.presentation.AuthWholeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthLoginViewModel @AssistedInject constructor(
	private val appContext: Context,
	@Assisted private val savedStateHandle: SavedStateHandle,
	@Assisted private val authWholeViewModel: AuthWholeViewModel
) : BaseViewModel() {
	@AssistedInject.Factory
	interface Factory {
		fun create(savedStateHandle: SavedStateHandle, authWholeViewModel: AuthWholeViewModel): AuthLoginViewModel
	}

	override fun onCreate(owner: LifecycleOwner) {
		authWholeViewModel.currentFragment = this::class.java.simpleName
	}

	private val _submitInProgress = MutableLiveData(false)
	val submitInProgress: LiveData<Boolean> = _submitInProgress

	fun onSubmitClick() {
		_submitInProgress.value = true


		viewModelScope.launch {
			try {
				loginUser()

				withContext(Dispatchers.Main) {
					navigate(AuthLoginFragmentDirections.actionAuthLoginFragmentPopAuth())
				}
			} catch (e: Exception) {
				_submitInProgress.value = false
				// some error shown
			}
		}
	}

	suspend fun loginUser() {
		withContext(Dispatchers.Default) {
			delay(1_500)
		}
	}
}
