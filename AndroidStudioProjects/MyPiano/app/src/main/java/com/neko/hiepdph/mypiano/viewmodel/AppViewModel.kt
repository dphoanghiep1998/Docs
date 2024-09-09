package com.neko.hiepdph.mypiano.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neko.hiepdph.mypiano.data.model.KeysRecord
import com.neko.hiepdph.mypiano.data.model.MicRecord
import com.neko.hiepdph.mypiano.data.repo.AppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appRepo: AppRepo) : ViewModel() {

    fun getListKeyRecord(): LiveData<List<KeysRecord>> {
        return appRepo.getListKeyRecord()
    }

    fun getListMicRecord(): LiveData<List<MicRecord>> {
        return appRepo.getListMicRecord()
    }

    fun insertMicRecord(micMicRecord: MicRecord) {
        viewModelScope.launch {
            appRepo.insertMicRecord(micMicRecord)
        }
    }

    fun insertKeyRecord(keysRecord: KeysRecord) {
        viewModelScope.launch {
            appRepo.insertKeyRecord(keysRecord)
        }
    }


    fun deleteMicRecord(id: Int) {
        viewModelScope.launch {
            appRepo.deleteMicRecord(id)
        }
    }

    fun deleteKeyRecord(id: Int) {
        viewModelScope.launch {
            appRepo.deleteKeyRecord(id)
        }
    }

}