buildscript {
	repositories {
		google()
		jcenter()
		maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
	}

	dependencies {
		classpath(Depends.Classpath.androidGradlePlugin)
		classpath(Depends.Classpath.kotlinPlugin)
		classpath(Depends.Classpath.androidxNavigationPlugin)
	}
}

allprojects {
	repositories {
		google()
		jcenter()
		maven { setUrl("https://ci.android.com/builds/submitted/6043188/androidx_snapshot/latest/repository/") }
		maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
	}
}
