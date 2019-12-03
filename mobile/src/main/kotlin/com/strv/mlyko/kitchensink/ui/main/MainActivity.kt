package com.strv.mlyko.kitchensink.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.strv.mlyko.kitchensink.KitchenSinkApp
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.di.InjectingFragmentFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
	@Inject
	lateinit var injectingFragmentFactory: InjectingFragmentFactory

	override fun onCreate(savedInstanceState: Bundle?) {
		(application as KitchenSinkApp).appComponent.inject(this)
		supportFragmentManager.fragmentFactory = injectingFragmentFactory
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}