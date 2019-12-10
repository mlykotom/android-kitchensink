package com.strv.mlyko.kitchensink.auth.presentation.register

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.arch.BaseView
import com.strv.mlyko.kitchensink.auth.databinding.FragmentAuthRegisterBinding
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
