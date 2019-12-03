buildscript {
	repositories {
		google()
		jcenter()
		maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") } // TODO remove later when not canary AS
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
		maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") } // TODO remove later when not canary AS
	}
}