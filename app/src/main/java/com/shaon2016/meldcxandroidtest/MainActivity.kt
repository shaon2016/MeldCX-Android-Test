package com.shaon2016.meldcxandroidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.databinding.ActivityMainBinding

class  MainActivity : BaseActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun viewRelatedTask() {

    }
}