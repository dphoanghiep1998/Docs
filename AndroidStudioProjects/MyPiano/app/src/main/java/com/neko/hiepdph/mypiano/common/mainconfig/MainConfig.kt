package com.neko.hiepdph.mypiano.common.mainconfig

import android.content.Context
import com.neko.hiepdph.mypiano.common.AppSharePreference
import com.neko.hiepdph.mypiano.common.Constant
import java.util.Locale

class MainConfig(private val context: Context) {
    companion object {
        fun newInstance(context: Context) = MainConfig(context)
    }

    var savedLanguage: String
        get() = AppSharePreference.getInstance(context)
            .getString(Constant.KEY_LANGUAGE, Locale.getDefault().language)
        set(savedLanguage) = AppSharePreference.getInstance(context)
            .saveString(Constant.KEY_LANGUAGE, savedLanguage)

    var showNote: Boolean
        get() = AppSharePreference.getInstance(context).getBoolean(Constant.KEY_LANGUAGE, true)
        set(showNote) = AppSharePreference.getInstance(context)
            .saveBoolean(Constant.KEY_LANGUAGE, showNote)


    var pitch: Boolean
        get() = AppSharePreference.getInstance(context).getBoolean(Constant.KEY_PITCH, false)
        set(pitch) = AppSharePreference.getInstance(context).saveBoolean(Constant.KEY_PITCH, pitch)

    var reverb: Boolean
        get() = AppSharePreference.getInstance(context).getBoolean(Constant.KEY_REVERB, false)
        set(reverb) = AppSharePreference.getInstance(context)
            .saveBoolean(Constant.KEY_REVERB, reverb)

    var speed: Float
        get() = AppSharePreference.getInstance(context).getFloat(Constant.KEY_SPEED, 100f)
        set(speed) = AppSharePreference.getInstance(context).saveFloat(Constant.KEY_SPEED, speed)

    var indexSong: Int
        get() = AppSharePreference.getInstance(context).getInt(Constant.KEY_INDEX_SONG, 0)
        set(indexSong) = AppSharePreference.getInstance(context)
            .saveInt(Constant.KEY_INDEX_SONG, indexSong)


    var indexTheme: Int
        get() = AppSharePreference.getInstance(context).getInt(Constant.KEY_INDEX_THEME, 0)
        set(indexTheme) = AppSharePreference.getInstance(context)
            .saveInt(Constant.KEY_INDEX_THEME, indexTheme)


    var indexThemeGuitar: Int
        get() = AppSharePreference.getInstance(context).getInt(Constant.KEY_INDEX_THEME_GUITAR, 0)
        set(indexThemeGuitar) = AppSharePreference.getInstance(context)
            .saveInt(Constant.KEY_INDEX_THEME_GUITAR, indexThemeGuitar)

    var indexThemeDrum: Int
        get() = AppSharePreference.getInstance(context).getInt(Constant.KEY_INDEX_THEME_DRUM, 0)
        set(indexThemeDrum) = AppSharePreference.getInstance(context)
            .saveInt(Constant.KEY_INDEX_THEME_DRUM, indexThemeDrum)

    var indexThumbMain: Int
        get() = AppSharePreference.getInstance(context).getInt(Constant.KEY_INDEX_THEME_MAIN, 0)
        set(indexThumbMain) = AppSharePreference.getInstance(context)
            .saveInt(Constant.KEY_INDEX_THEME_MAIN, indexThumbMain)

}