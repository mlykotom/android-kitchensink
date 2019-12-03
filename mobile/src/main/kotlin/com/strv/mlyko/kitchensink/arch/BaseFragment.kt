package com.strv.mlyko.kitchensink.arch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.strv.mlyko.kitchensink.BR

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
	lateinit var binding: B
		private set

	abstract fun inflateBinding(inflater: LayoutInflater): B

	open fun viewBindVariables(binding: B) {}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = inflateBinding(inflater).also {
			it.setVariable(BR.view, this)
			it.lifecycleOwner = viewLifecycleOwner
			viewBindVariables(it)
		}
		return binding.root
	}
}

abstract class BaseFragmentWithViewModel<VM : ViewModel, B : ViewDataBinding> : BaseFragment<B>() {
	abstract val viewModel: VM

	override fun viewBindVariables(binding: B) {
		super.viewBindVariables(binding)
		binding.setVariable(BR.viewModel, viewModel)
	}
}