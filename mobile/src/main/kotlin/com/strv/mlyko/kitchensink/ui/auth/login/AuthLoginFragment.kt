package com.strv.mlyko.kitchensink.ui.auth.login

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentAuthLoginBinding
import javax.inject.Inject

interface AuthLoginView {
	fun onSubmitClick()
}

class AuthLoginFragment @Inject constructor() : BaseFragment<FragmentAuthLoginBinding>(), AuthLoginView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthLoginBinding.inflate(inflater)

	override fun onSubmitClick() = findNavController().navigate(AuthLoginFragmentDirections.actionAuthLoginFragmentPopAuth())
}