package com.sslwireless.architechture.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sslwireless.architechture.data.local_db.dao.CategoryDao
import com.sslwireless.architechture.data.local_db.entity.Category


@Database(entities = arrayOf(Category::class) , version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}