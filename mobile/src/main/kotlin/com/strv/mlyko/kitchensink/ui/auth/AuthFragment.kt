package com.strv.mlyko.kitchensink.ui.auth

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.databinding.FragmentAuthBinding
import com.strv.mlyko.kitchensink.di.createCustomFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface AuthView {
	fun onRegisterClick()
	fun onLoginClick()
}

class AuthFragment @Inject constructor(
	private val authViewModelFactory: AuthViewModel.Factory
) : BaseFragmentWithViewModel<AuthViewModel, FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)

	override val viewModel: AuthViewModel by viewModels {
		createCustomFactory(this, arguments) { authViewModelFactory.create(it) }
	}

	override fun onRegisterClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthRegisterFragment())
	}

	override fun onLoginClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthLoginFragment())
	}
}

class AuthViewModel @AssistedInject constructor(
	private val appContext: Context,
	@Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
	@AssistedInject.Factory
	interface Factory {
		fun create(savedStateHandle: SavedStateHandle): AuthViewModel
	}

	val authCounter = savedStateHandle.getLiveData<Int>("authCounter", 0)
//	val authCounter = MutableLiveData<Int>(0)

	suspend fun delayedIncrement() {
		withContext(Dispatchers.Default) {
			authCounter.postValue(authCounter.value!! + 1)
			delay(1000)
		}
		delayedIncrement()
	}

	init {
		Log.d("asdfghjk", appContext.getString(R.string.app_name))

		viewModelScope.launch {
			delayedIncrement()
			Log.d("bnana", "banan")
		}
	}
}

//class AuthWholeViewModel @Inject constructor(
//
//)