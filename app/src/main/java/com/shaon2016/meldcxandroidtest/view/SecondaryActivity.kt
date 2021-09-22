package com.shaon2016.meldcxandroidtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.shaon2016.meldcxandroidtest.R
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.databinding.ActivitySecondaryBinding
import com.shaon2016.meldcxandroidtest.view.secondary.SecondaryVM

class SecondaryActivity : BaseActivity() {
    private lateinit var binding: ActivitySecondaryBinding
    private val vm by viewModels<SecondaryVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun viewRelatedTask() {
        title = "History"
    }
}