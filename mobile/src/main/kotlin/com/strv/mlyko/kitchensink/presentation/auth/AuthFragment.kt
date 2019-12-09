package com.strv.mlyko.kitchensink.presentation.auth

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.core.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.core.arch.BaseView
import com.strv.mlyko.kitchensink.core.di.createCustomFactory
import com.strv.mlyko.kitchensink.databinding.FragmentAuthBinding
import javax.inject.Inject

interface AuthView : BaseView {
	fun onRegisterClick()
	fun onLoginClick()
}

class AuthFragment @Inject constructor(
	private val authViewModelFactory: AuthViewModel.Factory
) : BaseFragmentWithViewModel<AuthViewModel, FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)

	// WARNING: requireParentFragment must be used!
	val authWholeViewModel: AuthWholeViewModel by navGraphViewModels(R.id.auth_graph) { viewModelFactory.create(requireParentFragment(), arguments) }

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