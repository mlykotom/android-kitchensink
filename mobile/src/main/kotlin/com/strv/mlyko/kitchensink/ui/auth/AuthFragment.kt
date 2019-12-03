package com.strv.mlyko.kitchensink.ui.auth

import android.view.LayoutInflater
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentAuthBinding

interface AuthView

class AuthFragment : BaseFragment<FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)
}