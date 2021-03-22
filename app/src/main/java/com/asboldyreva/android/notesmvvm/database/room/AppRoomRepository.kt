package com.asboldyreva.android.notesmvvm.database.room

import androidx.lifecycle.LiveData
import com.asboldyreva.android.notesmvvm.database.DatabaseRepository
import com.asboldyreva.android.notesmvvm.model.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }

    override fun signOut() {
        super.signOut()
    }
}