package com.strv.mlyko.kitchensink.ui.auth.register

import android.view.LayoutInflater
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentAuthRegisterBinding

interface AuthRegisterView {
	fun onSubmitClick()
}

class AuthRegisterFragment : BaseFragment<FragmentAuthRegisterBinding>(), AuthRegisterView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthRegisterBinding.inflate(inflater)

	override fun onSubmitClick() {
// nothing
	}
}