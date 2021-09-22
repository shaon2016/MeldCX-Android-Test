package com.shaon2016.meldcxandroidtest

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.databinding.ActivityMainBinding


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
            val url = binding.evUrl.text.toString()

            if (url.isNotEmpty())
                binding.web.loadUrl("https://www.google.com")
            else Toast.makeText(this, "Please insert a url", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initWeb() {
        binding.web.webViewClient = WebViewClient()
        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true
    }
}