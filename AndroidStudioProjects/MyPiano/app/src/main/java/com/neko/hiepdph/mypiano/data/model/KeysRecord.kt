package com.neko.hiepdph.mypiano.data.model

import android.os.Parcelable
import com.neko.hiepdph.mypiano.data.db.entity.KeysRecordEntity
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class KeysRecord(
    var id: Int = -1,
    var name: String,
    var time: Long,
    var duration: Int,
    var listKey:  List<AutoPlayEntity>
) : Parcelable {
    fun toKeysRecordEntity(): KeysRecordEntity {
        val newId = if (id == -1) 0 else id
        return KeysRecordEntity(
            id = newId, name, time, duration, listKey

        )
    }

    fun KeysRecordEntity.toKeysRecord(): KeysRecord {
        return KeysRecord(
            id, name, time, duration, listKey
        )
    }
}