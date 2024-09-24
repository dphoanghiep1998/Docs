package com.neko.hiepdph.mypiano.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mic_record")
data class MicRecordEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    val time: Long,
    val duration: Int,
    val path: String
) {}