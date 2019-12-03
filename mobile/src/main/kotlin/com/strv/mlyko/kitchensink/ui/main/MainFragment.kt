package com.strv.mlyko.kitchensink.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.strv.mlyko.kitchensink.R

class MainFragment : Fragment(R.layout.fragment_main) {
	val viewModel: MainViewModel by viewModels()
}

class MainViewModel : ViewModel() {

}