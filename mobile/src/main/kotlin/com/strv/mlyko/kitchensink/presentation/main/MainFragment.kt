package com.strv.mlyko.kitchensink.presentation.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.strv.mlyko.kitchensink.core.arch.BaseFragmentWithViewModel
import com.strv.mlyko.kitchensink.core.arch.BaseView
import com.strv.mlyko.kitchensink.databinding.FragmentMainBinding
import com.strv.mlyko.kitchensink.domain.AppVersion
import javax.inject.Inject

interface MainView : BaseView {
	fun onNextClick()
	fun onMyDialogClick()
}

class MainFragment @Inject constructor(
	private val sharedPreferences: SharedPreferences,
	private val appVersion: AppVersion
) : BaseFragmentWithViewModel<MainViewModel, FragmentMainBinding>(), MainView {

	override val viewModel: MainViewModel by viewModels()

	override fun inflateBinding(inflater: LayoutInflater) = FragmentMainBinding.inflate(inflater)

	override fun onNextClick() {
		findNavController().navigate(MainFragmentDirections.actionMainFragmentToAuthFragment())
	}

	override fun onMyDialogClick() {
		findNavController().navigate(MainFragmentDirections.actionMainFragmentToMyDialog("some awesome title $appVersion"))
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.displayMessage.observe(viewLifecycleOwner) {
			val message = it ?: return@observe
			Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
		}
	}
}
