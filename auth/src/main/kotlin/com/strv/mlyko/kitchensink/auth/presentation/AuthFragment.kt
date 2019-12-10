package com.strv.mlyko.kitchensink.auth.presentation

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.arch.BaseView
import com.strv.mlyko.kitchensink.auth.databinding.FragmentAuthBinding
import com.strv.mlyko.kitchensink.common.di.createCustomFactory
import javax.inject.Inject

interface AuthView : BaseView {
}

class AuthFragment @Inject constructor(
	private val authViewModelFactory: AuthViewModel.Factory
) : BaseFragmentWithViewModel<AuthViewModel, FragmentAuthBinding>(), AuthView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentAuthBinding.inflate(inflater)

	val authWholeViewModel: AuthWholeViewModel by navGraphViewModels(R.id.navigation_auth)

	override val viewModel: AuthViewModel by viewModels {
		createCustomFactory(this, arguments) { authViewModelFactory.create(it, authWholeViewModel, "userId moje") }
	}
}
