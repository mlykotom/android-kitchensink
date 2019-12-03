package com.strv.mlyko.kitchensink.ui.auth

import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.databinding.FragmentAuthBinding
import com.strv.mlyko.kitchensink.di.InjectingViewModelFactory
import javax.inject.Inject

interface AuthView {
	fun onRegisterClick()
	fun onLoginClick()
}

class AuthFragment @Inject constructor(
	private val vmFactory: InjectingViewModelFactory
) : BaseFragmentWithViewModel<AuthViewModel, FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)

	override val viewModel: AuthViewModel by viewModels { vmFactory }

	override fun onRegisterClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthRegisterFragment())
	}

	override fun onLoginClick() {
		viewModel.banan()
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthLoginFragment())
	}
}

class AuthViewModel @Inject constructor() : ViewModel() {

	fun banan() {
		Log.d("bnana", "banan")
	}
}