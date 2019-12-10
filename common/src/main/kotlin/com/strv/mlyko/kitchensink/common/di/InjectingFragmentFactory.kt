package com.strv.mlyko.kitchensink.common.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class InjectingFragmentFactory @Inject constructor(
	private val creators: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {
	override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
		val fragmentClass = loadFragmentClass(classLoader, className)
		val creator = creators[fragmentClass] ?: return createFragmentAsFallback(classLoader, className)
		try {
			return creator.get()
		} catch (e: Exception) {
			throw RuntimeException(e)
		}
	}

	private fun createFragmentAsFallback(classLoader: ClassLoader, className: String): Fragment {
		// WARNING: kept here, so Fragment can be instantiated without dagger. This applies for fragments outside of app (e.g. NavHostFragment)
		return super.instantiate(classLoader, className)
	}
}
