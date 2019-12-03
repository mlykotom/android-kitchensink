package com.strv.mlyko.kitchensink.arch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.strv.mlyko.kitchensink.BR

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    lateinit var binding: B

    abstract fun inflateBinding(inflater: LayoutInflater): B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateBinding(inflater).also {
            it.setVariable(BR.view, this)
        }
        return binding.root
    }
}