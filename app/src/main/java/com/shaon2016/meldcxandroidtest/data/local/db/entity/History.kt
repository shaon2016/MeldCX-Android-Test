package com.shaon2016.meldcxandroidtest.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var url: String = "",
    var time: String = "",
    @ColumnInfo(name = "image_byte_array", typeAffinity = ColumnInfo.BLOB)
    var imageByteArray : ByteArray = byteArrayOf(),
)
