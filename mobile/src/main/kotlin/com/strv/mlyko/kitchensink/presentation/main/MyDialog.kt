package com.strv.mlyko.kitchensink.presentation.main

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.strv.mlyko.kitchensink.R
import com.strv.mlyko.kitchensink.common.domain.AppVersion
import javax.inject.Inject

class MyDialog @Inject constructor(
	private val appContext: Context,
	private val appVersion: AppVersion
) : DialogFragment() {
	private val args by navArgs<MyDialogArgs>()

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		return AlertDialog.Builder(requireContext())
			.setTitle("Dialog title: ${args.title}")
			.setMessage(appContext.getString(R.string.app_name) + "$appVersion")
			.setPositiveButton("OK", null)
			.create()
	}
}
