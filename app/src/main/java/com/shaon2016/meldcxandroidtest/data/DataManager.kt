package com.shaon2016.meldcxandroidtest.data

import com.shaon2016.meldcxandroidtest.data.local.db.RoomHelper
import javax.inject.Inject

/**
* A helper class that connect database, Retrofit and preference with rest of the app architecture
* */
class DataManager @Inject constructor(val roomHelper: RoomHelper)