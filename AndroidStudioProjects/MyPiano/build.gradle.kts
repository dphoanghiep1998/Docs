// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.4")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}

//
//tasks.register<Delete>("clean") {
//    delete(rootProject.buildDir)
//}