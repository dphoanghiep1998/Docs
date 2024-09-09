package com.neko.hiepdph.mypiano.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.neko.hiepdph.mypiano.data.db.dao.KeyRecordDao
import com.neko.hiepdph.mypiano.data.db.dao.MicRecordDao
import com.neko.hiepdph.mypiano.data.db.entity.KeysRecordEntity
import com.neko.hiepdph.mypiano.data.db.entity.MicRecordEntity


@TypeConverters(value = [TypeConverter::class])
@Database(
    entities = [MicRecordEntity::class, KeysRecordEntity::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val micRecordDao: MicRecordDao
    abstract val keyRecordDao: KeyRecordDao

}
