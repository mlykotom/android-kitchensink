package com.strv.mlyko.kitchensink.presentation.test

import android.view.LayoutInflater
import com.strv.mlyko.kitchensink.arch.BaseFragment
import com.strv.mlyko.kitchensink.databinding.FragmentTestBinding
import javax.inject.Inject

interface TestView {

}

class TestFragment @Inject constructor() : BaseFragment<FragmentTestBinding>(), TestView {
	override fun inflateBinding(inflater: LayoutInflater) = FragmentTestBinding.inflate(inflater)
}
