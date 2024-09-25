package com.neko.hiepdph.mypiano.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neko.hiepdph.mypiano.data.db.entity.KeysRecordEntity
import com.neko.hiepdph.mypiano.data.model.KeysRecord

@Dao
interface KeyRecordDao {
    @Query("select * from key_record order by id DESC")
    fun getListKeyRecord(): LiveData<List<KeysRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKeyRecord(entity: KeysRecordEntity)

    @Query("delete from key_record where id = :id ")
    fun deleteKeyRecord(id: Int)
}