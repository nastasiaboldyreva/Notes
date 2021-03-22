package com.asboldyreva.android.notesmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.asboldyreva.android.notesmvvm.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes

    fun signOut() {
        REPOSITORY.signOut()
    }
}