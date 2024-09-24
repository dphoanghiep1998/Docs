package com.neko.hiepdph.mypiano.data.model

import android.os.Parcelable
import com.neko.hiepdph.mypiano.data.db.entity.MicRecordEntity
import kotlinx.parcelize.Parcelize

@Parcelize
class MicRecord(
    val id: Int = -1, var name: String, val time: Long, val duration: Int, val path: String
) : Parcelable {
    fun toMicRecordEntity(): MicRecordEntity {
        val newId = if (id == -1) 0 else id
        return MicRecordEntity(
            id = newId, name, time, duration, path

        )
    }

    fun MicRecordEntity.toMicRecord(): MicRecord {
        return MicRecord(
            id, name, time, duration, path
        )
    }
}