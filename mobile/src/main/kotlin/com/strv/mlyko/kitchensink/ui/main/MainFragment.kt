package com.strv.mlyko.kitchensink.ui.main

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.databinding.FragmentMainBinding

interface MainView {
	fun onNextClick()
}

class MainFragment : BaseFragmentWithViewModel<MainViewModel, FragmentMainBinding>(), MainView {
	override val viewModel: MainViewModel by viewModels { SavedStateViewModelFactory(requireActivity().application, this) }

	override fun inflateBinding(inflater: LayoutInflater) = FragmentMainBinding.inflate(inflater)

	override fun onNextClick() {
		findNavController().navigate(MainFragmentDirections.actionMainFragmentToAuthFragment())
	}
}

