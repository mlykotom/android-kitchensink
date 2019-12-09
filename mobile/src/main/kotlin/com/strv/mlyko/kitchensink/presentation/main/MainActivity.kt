package com.strv.mlyko.kitchensink.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.domain.appComponent
import com.strv.mlyko.kitchensink.core.di.InjectingFragmentFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
	@Inject
	lateinit var injectingFragmentFactory: InjectingFragmentFactory

	override fun onCreate(savedInstanceState: Bundle?) {
		appComponent.inject(this)
		supportFragmentManager.fragmentFactory = injectingFragmentFactory

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}