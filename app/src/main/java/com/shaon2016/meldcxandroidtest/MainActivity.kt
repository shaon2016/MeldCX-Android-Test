package com.shaon2016.meldcxandroidtest

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.databinding.ActivityMainBinding
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import com.shaon2016.meldcxandroidtest.util.U
import java.lang.Exception


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

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
        val url = binding.evUrl.text.toString()

        if (url.isNotEmpty())
            binding.web.loadUrl("https://www.google.com")
        else Toast.makeText(this, "Please insert a url", Toast.LENGTH_SHORT).show()

        U.hideKeyboard(this)
    }

    private fun initWeb() {
        binding.web.webViewClient = WebViewClient()
        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true
    }

    private fun takeWebScreenshot() {
        val b = Bitmap.createBitmap(binding.web.width, binding.web.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(b)
        binding.web.draw(canvas)

    }


}