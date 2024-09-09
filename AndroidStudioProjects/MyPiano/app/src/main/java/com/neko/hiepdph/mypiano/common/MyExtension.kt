package com.neko.hiepdph.mypiano.common

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.SystemClock
import android.view.View
import com.neko.hiepdph.mypiano.common.mainconfig.MainConfig
import java.util.Locale

val Context.config: MainConfig get() = MainConfig.newInstance(this)


fun Context.createContext(newLocale: Locale): Context = if (buildMaxVersionN()) {
    createContextAndroidN(newLocale)
} else {

    createContextLegacy(newLocale)
}


private fun Context.createContextAndroidN(newLocale: Locale): Context {
    val resources: Resources = resources
    val configuration: Configuration = resources.configuration
    configuration.setLocale(newLocale)
    return createConfigurationContext(configuration)
}

private fun Context.createContextLegacy(newLocale: Locale): Context {
    val resources: Resources = resources
    val configuration: Configuration = resources.configuration
    configuration.locale = newLocale
    resources.updateConfiguration(configuration, resources.displayMetrics)
    return this
}

fun View.clickWithDebounce(debounceTime: Long = 400L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}


