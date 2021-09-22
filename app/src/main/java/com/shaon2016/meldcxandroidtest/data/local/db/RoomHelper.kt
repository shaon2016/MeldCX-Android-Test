package com.shaon2016.meldcxandroidtest.data.local.db

import android.content.Context
import androidx.room.Room
import com.lastblade.androidarchitecturewithhilt.data.local.db.RoomDB

class RoomHelper(context: Context)  {

    private val db = Room.databaseBuilder(context, RoomDB::class.java, "BD_NAME").allowMainThreadQueries().build()

    fun getDatabase(): RoomDB {
        return db
    }
}