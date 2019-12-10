package com.strv.mlyko.kitchensink.core.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.strv.mlyko.kitchensink.core.arch.events.SingleLiveEvent

interface Navigator {
	val navigator: LiveData<NavigationCommand>

	fun navigate(command: NavigationCommand)

	fun navigate(
		directions: NavDirections,
		options: NavOptions? = null,
		extras: androidx.navigation.Navigator.Extras? = null
	)

	fun goBack(to: NavigationCommand.BackTo? = null)
}

class NavigatorImpl : Navigator {
	override fun navigate(command: NavigationCommand) {
		_navigator.postValue(command)
	}

	private val _navigator = SingleLiveEvent<NavigationCommand>()

	override val navigator: LiveData<NavigationCommand> = _navigator

	override fun navigate(
		directions: NavDirections,
		options: NavOptions?,
		extras: androidx.navigation.Navigator.Extras?
	) {
		navigate(NavigationCommand.To(directions, options, extras))
	}

	override fun goBack(to: NavigationCommand.BackTo?) {
		navigate(to ?: NavigationCommand.Back)
	}
}

sealed class NavigationCommand {
	data class To(
		val directions: NavDirections,
		val options: NavOptions? = null,
		val extras: androidx.navigation.Navigator.Extras? = null
	) : NavigationCommand()

	object Back : NavigationCommand()

	data class BackTo(
		val destinationId: Int,
		val inclusive: Boolean
	) : NavigationCommand()
}

/**
 * Extension function for fragment with ViewModel observing navigator commands
 * @param navControllerProvider as lambda, so that it's called only at the time of navigation command (usually after view was created)
 */
fun BaseFragmentWithViewModel<*, *>.observeNavigation(navControllerProvider: () -> NavController = { findNavController() }) {
	viewModel.navigator.observe(this) { command ->
		when (command) {
			is NavigationCommand.To -> navControllerProvider().navigate(
				command.directions.actionId,
				command.directions.arguments,
				command.options,
				command.extras
			)

			NavigationCommand.Back -> navControllerProvider().popBackStack()

			is NavigationCommand.BackTo -> navControllerProvider().popBackStack(
				command.destinationId,
				command.inclusive
			)
		}
	}
}