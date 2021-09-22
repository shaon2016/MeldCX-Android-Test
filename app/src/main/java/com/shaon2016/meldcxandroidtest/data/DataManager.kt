package com.shaon2016.meldcxandroidtest.data

import com.shaon2016.meldcxandroidtest.data.local.db.RoomHelper
import javax.inject.Inject

class DataManager @Inject constructor( roomHelper: RoomHelper
)  {
    val roomHelper = roomHelper
}