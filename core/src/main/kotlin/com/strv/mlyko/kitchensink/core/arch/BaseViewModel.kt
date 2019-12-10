package com.strv.mlyko.kitchensink.core.arch

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(),
	DefaultLifecycleObserver,
	Navigator by NavigatorImpl()
