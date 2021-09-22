package com.sslwireless.architechture.data

import com.sslwireless.architechture.data.local_db.RoomHelper
import com.sslwireless.architechture.data.network.ApiHelper
import com.sslwireless.architechture.data.prefence.PreferencesHelper
import javax.inject.Inject

class DataManager @Inject constructor(
    val preferencesHelper: PreferencesHelper, val roomHelper: RoomHelper,val apiHelper: ApiHelper
)