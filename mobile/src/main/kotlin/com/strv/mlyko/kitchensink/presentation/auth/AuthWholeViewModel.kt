package com.strv.mlyko.kitchensink.presentation.auth

import android.util.Log
import com.strv.mlyko.kitchensink.core.arch.BaseViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class AuthWholeViewModel @Inject constructor() : BaseViewModel() {
	var currentFragment: String by Delegates.observable("") { property, oldValue, newValue ->
		Log.d("AuthWholeViewModel-${this.hashCode()}", "$oldValue -> $newValue")
	}

	init {
		Log.d("AuthWholeViewModel", "instance $this")
	}
}