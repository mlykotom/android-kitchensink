package com.strv.mlyko.kitchensink.auth.presentation.login

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.arch.BaseView
import com.strv.mlyko.kitchensink.auth.databinding.FragmentAuthLoginBinding
import com.strv.mlyko.kitchensink.auth.presentation.AuthWholeViewModel
import com.strv.mlyko.kitchensink.common.di.createCustomFactory
import javax.inject.Inject

interface AuthLoginView : BaseView {
}

class AuthLoginFragment @Inject constructor(
	private val authLoginViewModelFactory: AuthLoginViewModel.Factory
) : BaseFragmentWithViewModel<AuthLoginViewModel, FragmentAuthLoginBinding>(), AuthLoginView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthLoginBinding.inflate(inflater)

	private val authWholeViewModel: AuthWholeViewModel by navGraphViewModels(R.id.navigation_auth)
	override val viewModel: AuthLoginViewModel by viewModels { createCustomFactory(this, arguments) { authLoginViewModelFactory.create(it, authWholeViewModel) } }
}
