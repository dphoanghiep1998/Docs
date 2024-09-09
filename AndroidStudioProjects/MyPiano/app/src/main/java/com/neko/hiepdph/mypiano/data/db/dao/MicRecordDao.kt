package com.neko.hiepdph.mypiano.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neko.hiepdph.mypiano.data.db.entity.KeysRecordEntity
import com.neko.hiepdph.mypiano.data.db.entity.MicRecordEntity
import com.neko.hiepdph.mypiano.data.model.KeysRecord
import com.neko.hiepdph.mypiano.data.model.MicRecord

@Dao
interface MicRecordDao {
    @Query("select * from mic_record")
    fun getListMicRecord(): LiveData<List<MicRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMicRecord(entity: MicRecordEntity)

    @Query("delete from mic_record where id = :id ")
    fun deleteMicRecord(id: Int)
}