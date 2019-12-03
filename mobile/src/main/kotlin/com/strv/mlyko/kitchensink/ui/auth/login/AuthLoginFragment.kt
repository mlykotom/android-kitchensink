package com.strv.mlyko.kitchensink.ui.auth.login

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentAuthLoginBinding

interface AuthLoginView {
	fun onSubmitClick()
}

class AuthLoginFragment : BaseFragment<FragmentAuthLoginBinding>(), AuthLoginView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthLoginBinding.inflate(inflater)

	override fun onSubmitClick() = findNavController().navigate(AuthLoginFragmentDirections.actionAuthLoginFragmentPopAuth())
}