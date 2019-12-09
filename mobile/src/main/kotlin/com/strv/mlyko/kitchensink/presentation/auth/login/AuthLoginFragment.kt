package com.strv.mlyko.kitchensink.presentation.auth.login

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.core.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.core.arch.BaseView
import com.strv.mlyko.kitchensink.core.arch.BaseViewModel
import com.strv.mlyko.kitchensink.core.di.createCustomFactory
import com.strv.mlyko.kitchensink.databinding.FragmentAuthLoginBinding
import com.strv.mlyko.kitchensink.presentation.auth.AuthWholeViewModel
import javax.inject.Inject

interface AuthLoginView : BaseView {
	fun onSubmitClick()
}

class AuthLoginFragment @Inject constructor(
	private val authLoginViewModelFactory: AuthLoginViewModel.Factory
) : BaseFragmentWithViewModel<AuthLoginViewModel, FragmentAuthLoginBinding>(), AuthLoginView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthLoginBinding.inflate(inflater)

	override fun onSubmitClick() = findNavController().navigate(AuthLoginFragmentDirections.actionAuthLoginFragmentPopAuth())

	private val authWholeViewModel: AuthWholeViewModel by navGraphViewModels(R.id.auth_graph)
	override val viewModel: AuthLoginViewModel by viewModels { createCustomFactory(this, arguments) { authLoginViewModelFactory.create(it, authWholeViewModel) } }
}

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
}