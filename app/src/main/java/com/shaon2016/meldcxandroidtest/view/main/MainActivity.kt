package com.shaon2016.meldcxandroidtest.view.main

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.databinding.ActivityMainBinding
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.activity.viewModels
import com.shaon2016.meldcxandroidtest.MainVM
import com.shaon2016.meldcxandroidtest.util.U


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private val vm by viewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun viewRelatedTask() {
        initWeb()

        binding.btnGo.setOnClickListener {
            loadWeb()
        }

        binding.btnCapture.setOnClickListener {
            takeWebScreenshot()
        }
    }

    private fun loadWeb() {

        if (checkUrl())
            binding.web.loadUrl("https://www.google.com")


        U.hideKeyboard(this)
    }

    private fun checkUrl(): Boolean {
        val url = binding.evUrl.text.toString()

        if (url.isNotEmpty()) return true

        Toast.makeText(this, "Please insert a url", Toast.LENGTH_SHORT).show()
        return false
    }

    private fun initWeb() {
        binding.web.webViewClient = WebViewClient()
        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true
    }

    private fun takeWebScreenshot() {
        if (!checkUrl()) return

        val b = Bitmap.createBitmap(binding.web.width, binding.web.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(b)
        binding.web.draw(canvas)

        vm.saveToDb(b, binding.web.url!!)
    }


}