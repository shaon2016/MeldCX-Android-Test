package com.shaon2016.meldcxandroidtest.data.local.db

import android.content.Context
import androidx.room.Room

class RoomHelper(private val context: Context)  {

    private val db = Room.databaseBuilder(context, RoomDB::class.java, "BD_NAME").allowMainThreadQueries().build()

    /**
     * Get database instance
     * */
    fun getDatabase(): RoomDB {
        return db
    }
}