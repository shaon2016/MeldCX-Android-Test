package com.sslwireless.architechture.data.local_db

import android.content.Context
import androidx.room.Room

class RoomHelper(private val context: Context)  {

    private val db = Room.databaseBuilder(context, RoomDB::class.java, "BD_NAME").allowMainThreadQueries().build()


    fun getDatabase():RoomDB{
        return db
    }
}