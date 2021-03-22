package com.asboldyreva.android.notesmvvm.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.asboldyreva.android.notesmvvm.model.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM notesTable")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)

}