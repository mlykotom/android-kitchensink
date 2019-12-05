package com.strv.mlyko.kitchensink.ui.auth

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.databinding.FragmentAuthBinding
import com.strv.mlyko.kitchensink.di.createCustomFactory
import javax.inject.Inject

interface AuthView {
	fun onRegisterClick()
	fun onLoginClick()
}

class AuthFragment @Inject constructor(
	private val authViewModelFactory: AuthViewModel.Factory
) : BaseFragmentWithViewModel<AuthViewModel, FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)

	val authWholeViewModel: AuthWholeViewModel by navGraphViewModels(R.id.auth_graph)

	override val viewModel: AuthViewModel by viewModels {
		createCustomFactory(this, arguments) { authViewModelFactory.create(it, authWholeViewModel, "userId moje") }
	}

	override fun onRegisterClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthRegisterFragment())
	}

	override fun onLoginClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthLoginFragment())
	}
}