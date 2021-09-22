package com.shaon2016.meldcxandroidtest.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shaon2016.meldcxandroidtest.data.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Override it to viewRelatedTask() method to work with views
     * */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewRelatedTask()
    }

    /**
     * view initialize goes here.
     * Every activity will override it
     * */
    abstract fun viewRelatedTask()

}