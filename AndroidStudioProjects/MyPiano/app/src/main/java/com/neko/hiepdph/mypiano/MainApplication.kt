package com.neko.hiepdph.mypiano

import android.app.Application
import android.media.SoundPool
import com.neko.hiepdph.mypiano.common.AppSharePreference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    lateinit var soundPool:SoundPool

    companion object {
        lateinit var app: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        AppSharePreference.getInstance(this)
        soundPool=SoundPool.Builder().setMaxStreams(6).build()
    }
}