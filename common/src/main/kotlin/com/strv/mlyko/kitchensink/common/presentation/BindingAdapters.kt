package com.strv.mlyko.kitchensink.common.presentation

import android.view.View
import androidx.databinding.BindingConversion

@BindingConversion
fun convertBooleanToVisibility(isVisible: Boolean) = when (isVisible) {
	true -> View.VISIBLE
	false -> View.GONE
}
