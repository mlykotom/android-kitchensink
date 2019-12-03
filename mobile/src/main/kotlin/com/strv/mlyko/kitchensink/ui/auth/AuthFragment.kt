package com.strv.mlyko.kitchensink.ui.auth

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentAuthBinding

interface AuthView {
	fun onRegisterClick()
	fun onLoginClick()
}

class AuthFragment : BaseFragment<FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)

	override fun onRegisterClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthRegisterFragment())
	}

	override fun onLoginClick() {
		findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToAuthLoginFragment())
	}
}