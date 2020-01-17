buildscript {
	repositories {
		google()
		jcenter()
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
	}
}
