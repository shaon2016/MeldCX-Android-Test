package com.shaon2016.meldcxandroidtest

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.shaon2016.meldcxandroidtest.base.BaseViewModel
import com.shaon2016.meldcxandroidtest.data.DataManager
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import com.shaon2016.meldcxandroidtest.util.DateUtil
import com.shaon2016.meldcxandroidtest.util.U
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

    private val historyDao = dataManager.roomHelper.getDatabase().historyDao()

    fun saveToDb(bitmap: Bitmap, url: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val h = History()
            h.url = url
            h.imageByteArray = U.bitmapToByteArray(bitmap)
            h.time = DateUtil.todayDateForView

            historyDao.insert(h)
        }
    }
}