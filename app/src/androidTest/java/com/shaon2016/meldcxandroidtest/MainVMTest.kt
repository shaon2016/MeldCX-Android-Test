package com.shaon2016.meldcxandroidtest

import android.graphics.Bitmap
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shaon2016.meldcxandroidtest.data.DataManager
import com.shaon2016.meldcxandroidtest.data.local.db.RoomHelper
import com.shaon2016.meldcxandroidtest.data.local.db.dao.HistoryDao
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import com.shaon2016.meldcxandroidtest.view.main.MainVM
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class MainVMTest : TestCase() {

    private lateinit var dataManager: DataManager
    private lateinit var roomHelper: RoomHelper

    private lateinit var dao: HistoryDao

    @Before
    fun setup() {
        roomHelper = RoomHelper(ApplicationProvider.getApplicationContext())
        dataManager = DataManager(roomHelper)

        dao = dataManager.roomHelper.getDatabase().historyDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        roomHelper.getDatabase().close()
    }

    @Test
    @Throws(Exception::class)
    fun addNewHistory() {
        val h = History(url = "test_url")
        dao.insert(h)

        val h2 = dao.findByUrl("test_url")

        assertThat(h2.url, equalTo(h.url))
    }
}