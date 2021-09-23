package com.shaon2016.meldcxandroidtest.view.main

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaon2016.meldcxandroidtest.data.DataManager
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import com.shaon2016.meldcxandroidtest.util.DateUtil
import com.shaon2016.meldcxandroidtest.util.U
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(dataManager: DataManager) : ViewModel() {

    private val historyDao = dataManager.roomHelper.getDatabase().historyDao()

    /**
     * Save content to database
     * */
    fun saveToDb(bitmap: Bitmap, url: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val h = History()
            h.url = url
            h.imageByteArray = U.bitmapToByteArray(bitmap)
            h.time = DateUtil.todayDateTimeForView

            historyDao.insert(h)
        }
    }
}