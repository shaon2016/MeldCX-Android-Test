package com.shaon2016.meldcxandroidtest.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shaon2016.meldcxandroidtest.data.local.db.dao.HistoryDao
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History

@Database(entities = [History::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}