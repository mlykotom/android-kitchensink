package com.strv.mlyko.kitchensink.core.arch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import com.strv.mlyko.kitchensink.core.BR
import com.strv.mlyko.kitchensink.core.di.InjectingSavedStateViewModelFactory
import javax.inject.Inject

interface BaseView

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

abstract class BaseFragmentWithViewModel<VM : BaseViewModel, B : ViewDataBinding> : BaseFragment<B>(), HasDefaultViewModelProviderFactory {
	abstract val viewModel: VM

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		lifecycle.addObserver(viewModel)
		observeNavigation()
	}

	override fun viewBindVariables(binding: B) {
		super.viewBindVariables(binding)
		binding.setVariable(BR.viewModel, viewModel)
	}

	@Inject
	lateinit var viewModelFactory: InjectingSavedStateViewModelFactory

	private val cachedViewModelFactory by lazy {
		viewModelFactory.create(this, arguments)
	}

	override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory = cachedViewModelFactory
}