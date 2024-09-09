package com.neko.hiepdph.mypiano.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudioFile(val name: String, val audioPath: String, val duration: Long) : Parcelable {}