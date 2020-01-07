package com.strv.mlyko.kitchensink.common.domain.manager

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class UserManager @Inject constructor(
	private val sharedPreferences: SharedPreferences
) {
	val isUserLoggedIn = ConflatedBroadcastChannel(false)

	init {
		GlobalScope.launch {
			isUserLoggedIn.consumeEach { b->
				Log.d("USERMANAGER", "user logged in $b")
			}
		}

		val isLoggedLocally = sharedPreferences.getBoolean("user_logged", false)
		isUserLoggedIn.offer(isLoggedLocally)
	}

	fun logUser(isLogged: Boolean) {
		sharedPreferences.edit {
			putBoolean("user_logged", isLogged)
			isUserLoggedIn.offer(isLogged)
		}
	}
}

