package com.strv.mlyko.kitchensink.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.common.di.CommonInjectingFactory
import com.strv.mlyko.kitchensink.domain.appComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
	@Inject
	lateinit var injectingFragmentFactory: CommonInjectingFactory

	override fun onCreate(savedInstanceState: Bundle?) {
		appComponent.inject(this)
		supportFragmentManager.fragmentFactory = injectingFragmentFactory
		super.onCreate(savedInstanceState)
	}
}

