package com.asboldyreva.android.notesmvvm.database

import androidx.lifecycle.LiveData
import com.asboldyreva.android.notesmvvm.model.AppNote

interface DatabaseRepository {
    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess: () -> Unit)
    suspend fun delete(note: AppNote, onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}
    fun signOut(){}
}