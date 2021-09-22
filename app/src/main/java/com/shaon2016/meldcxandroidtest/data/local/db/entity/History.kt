package com.shaon2016.meldcxandroidtest.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val url: String = "",
    val time: String = ""
)
