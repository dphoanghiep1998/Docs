package com.neko.hiepdph.mypiano.data.repo

import androidx.lifecycle.LiveData
import com.neko.hiepdph.mypiano.data.db.dao.KeyRecordDao
import com.neko.hiepdph.mypiano.data.db.dao.MicRecordDao
import com.neko.hiepdph.mypiano.data.model.KeysRecord
import com.neko.hiepdph.mypiano.data.model.MicRecord
import com.neko.hiepdph.mypiano.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppRepo @Inject constructor(
    private val micRecordDao: MicRecordDao,
    private val keyRecordDao: KeyRecordDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    fun getListKeyRecord(): LiveData<List<KeysRecord>> {
        return keyRecordDao.getListKeyRecord()
    }

    suspend fun insertKeyRecord(keysRecord: KeysRecord) = withContext(dispatcher) {
        keyRecordDao.insertKeyRecord(keysRecord.toKeysRecordEntity())
    }

    suspend fun deleteKeyRecord(id: Int) = withContext(dispatcher) {
        keyRecordDao.deleteKeyRecord(id)
    }

    fun getListMicRecord(): LiveData<List<MicRecord>> {
        return micRecordDao.getListMicRecord()
    }

    suspend fun insertMicRecord(micRecord: MicRecord) = withContext(dispatcher) {
        micRecordDao.insertMicRecord(micRecord.toMicRecordEntity())
    }

    suspend fun deleteMicRecord(id: Int) = withContext(dispatcher) {
        micRecordDao.deleteMicRecord(id)
    }
}