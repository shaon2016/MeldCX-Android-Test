package com.shaon2016.meldcxandroidtest.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM History")
    fun all(): Flow<List<History>>

    @Insert
    fun insert(h: History)

    @Delete
    fun delete(h: History): Int

    @Query("SELECT * FROM History where url = :url")
    fun findByUrl(url: String): History

}