package com.neko.hiepdph.mypiano.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.neko.hiepdph.mypiano.data.model.AutoPlayEntity

@Entity(tableName = "key_record")
data class KeysRecordEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    val name: String,
    val time: Long,
    val duration: Int,
    val listKey: List<AutoPlayEntity>
) {}