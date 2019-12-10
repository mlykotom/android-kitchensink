package com.strv.mlyko.kitchensink.auth.presentation.login

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.arch.BaseViewModel
import com.strv.mlyko.kitchensink.auth.presentation.AuthWholeViewModel

class AuthLoginViewModel @AssistedInject constructor(
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

	fun onSubmitClick() {
		navigate(AuthLoginFragmentDirections.actionAuthLoginFragmentPopAuth())
	}
}
