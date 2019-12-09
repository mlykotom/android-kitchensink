package com.strv.mlyko.kitchensink.presentation.auth.register

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.core.arch.BaseFragment
import com.strv.mlyko.kitchensink.core.arch.BaseView
import com.strv.mlyko.kitchensink.databinding.FragmentAuthRegisterBinding
import javax.inject.Inject

interface AuthRegisterView : BaseView {
	fun onSubmitClick()
}

class AuthRegisterFragment @Inject constructor() : BaseFragment<FragmentAuthRegisterBinding>(), AuthRegisterView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthRegisterBinding.inflate(inflater)

	override fun onSubmitClick() {
		findNavController().navigate(AuthRegisterFragmentDirections.actionAuthRegisterFragmentPopAuth())
	}
}