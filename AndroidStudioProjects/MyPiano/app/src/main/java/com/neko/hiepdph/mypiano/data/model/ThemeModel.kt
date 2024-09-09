package com.neko.hiepdph.mypiano.data.model

import android.os.Parcelable
import com.neko.hiepdph.mypiano.data.model.Piano.PianoKeyType
import kotlinx.parcelize.Parcelize

/**
 * Created by ChengTao on 2017-02-20.
 */
/**
 * 自动播放实体
 */
@Parcelize
data class ThemeModel(
    var type: PianoKeyType? = null,
    var group: Int = 0,
    var position: Int = 0,
    var currentBreakTime: Long = 0
) : Parcelable {


    override fun toString(): String {
        return ("AutoPlayEntity{" + "type=" + type + ", group=" + group + ", position=" + position + ", currentBreakTime=" + currentBreakTime + '}')
    }
}