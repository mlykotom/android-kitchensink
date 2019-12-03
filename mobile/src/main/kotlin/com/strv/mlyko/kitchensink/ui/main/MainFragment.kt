package com.strv.mlyko.kitchensink.ui.main

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentMainBinding

interface MainView {
	fun onNextClick()
}

class MainFragment : BaseFragment<FragmentMainBinding>(), MainView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentMainBinding.inflate(inflater)
	val viewModel: MainViewModel by viewModels()

	override fun onNextClick() {
		findNavController().navigate(MainFragmentDirections.actionMainFragmentToAuthFragment())
	}
}

class MainViewModel : ViewModel() {

}