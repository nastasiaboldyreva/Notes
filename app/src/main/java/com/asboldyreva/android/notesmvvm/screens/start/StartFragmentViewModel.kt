package com.asboldyreva.android.notesmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.asboldyreva.android.notesmvvm.database.firebase.AppFirebaseRepository
import com.asboldyreva.android.notesmvvm.database.room.AppRoomDatabase
import com.asboldyreva.android.notesmvvm.database.room.AppRoomRepository
import com.asboldyreva.android.notesmvvm.utilits.REPOSITORY
import com.asboldyreva.android.notesmvvm.utilits.TYPE_FIREBASE
import com.asboldyreva.android.notesmvvm.utilits.TYPE_ROOM
import com.asboldyreva.android.notesmvvm.utilits.showToast

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({ onSuccess() }, { showToast(it) })
            }
        }
    }
}