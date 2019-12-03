package com.strv.mlyko.kitchensink.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.strv.mlyko.kitchensink.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.databinding.FragmentMainBinding
import javax.inject.Inject

interface MainView {
	fun onNextClick()
}

class MainFragment @Inject constructor(
	private val sharedPreferences: SharedPreferences
) : BaseFragmentWithViewModel<MainViewModel, FragmentMainBinding>(), MainView {
	override val viewModel: MainViewModel by viewModels { SavedStateViewModelFactory(requireActivity().application, this) }

	override fun inflateBinding(inflater: LayoutInflater) = FragmentMainBinding.inflate(inflater)

	override fun onNextClick() {
		findNavController().navigate(MainFragmentDirections.actionMainFragmentToAuthFragment())
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.displayMessage.observe(viewLifecycleOwner) {
			val message = it ?: return@observe
			Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
		}
	}

	override fun onStart() {
		super.onStart()
		Log.d("Asd", sharedPreferences.getString("banan", "neni tam"))
	}
}

