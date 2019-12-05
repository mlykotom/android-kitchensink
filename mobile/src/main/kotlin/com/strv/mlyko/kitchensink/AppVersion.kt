package com.strv.mlyko.kitchensink

data class AppVersion(
	val versionCode: Int,
	val versionName: String
){
	override fun toString(): String ="($versionCode|$versionName)"
}