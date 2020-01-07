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
import com.strv.mlyko.kitchensink.common.domain.manager.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext

class AuthLoginViewModel @AssistedInject constructor(
	private val appContext: Context,
	@Assisted private val savedStateHandle: SavedStateHandle,
	@Assisted private val authWholeViewModel: AuthWholeViewModel,
	private val userManager: UserManager
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

	private var loginJob: Job? = null

	fun onSubmitClick() {
		_submitInProgress.value = true
		loginJob?.cancel()


		loginJob = viewModelScope.launch {
			try {
				loginUser()

				withContext(Dispatchers.Main) {
					userManager.logUser(true)
					navigate(AuthLoginFragmentDirections.actionAuthLoginFragmentPopAuth())
				}
			} catch (e: Exception) {
				userManager.logUser(false)
				_submitInProgress.value = false
				// some error shown
			}
		}
	}

	suspend fun loginUser() {
		withContext(Dispatchers.Default) {
			delay(2_500)
		}
	}

	suspend fun xx() {
		val x = suspendCancellableCoroutine<Boolean> {



		}
	}
}
