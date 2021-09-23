package com.shaon2016.meldcxandroidtest.view.main

import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.databinding.ActivityMainBinding
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Base64
import android.webkit.URLUtil
import androidx.activity.viewModels
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import com.shaon2016.meldcxandroidtest.util.U
import com.shaon2016.meldcxandroidtest.view.secondary.SecondaryActivity


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private val vm by viewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun viewRelatedTask() {
        title = "Home"

        initWeb()

        val history = intent?.extras?.getSerializable("history") as History?

        history?.let {
            binding.evUrl.setText(it.url)

            loadImageToWebView(it)

            loadWeb()
        }

       handleBtn()
    }

    private fun handleBtn() {
        binding.btnGo.setOnClickListener {
            loadWeb()
        }

        binding.btnCapture.setOnClickListener {
            takeWebScreenshot()
        }

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, SecondaryActivity::class.java))
        }
    }

    /**
     * Load web page to web page after clicking the go button
     * */
    private fun loadWeb() {

        if (checkUrl())
            binding.web.loadUrl(binding.evUrl.text.toString())

        U.hideKeyboard(this)
    }

    /**
     * Load preview from history page that we click to see
     * */
    private fun loadImageToWebView(it: History) {
        var html = "<html><body><img src='{IMAGE_PLACEHOLDER}' width=400 height=400/></body></html>"

        val bitmapBase64 = Base64.encodeToString(it.imageByteArray, Base64.DEFAULT)
        val image = "data:image/png;base64,$bitmapBase64"

        html = html.replace("{IMAGE_PLACEHOLDER}", image);
        binding.web.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "utf-8", "");
    }

    /**
     * Checking user inserted a url or not
     * */
    private fun checkUrl(): Boolean {
        val url = binding.evUrl.text.toString().trim()

        if (url.isNotEmpty() && url.startsWith("http") && URLUtil.isValidUrl(url)) return true

        Toast.makeText(this, "Please insert a valid url with http or https", Toast.LENGTH_SHORT).show()
        return false
    }

    /**
     * Initializing web to load
     * */
    private fun initWeb() {
        binding.web.webViewClient = WebViewClient()
        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true
    }

    /**
     * Taking web content screenshot and saving it to db
     * */
    private fun takeWebScreenshot() {
        if (!checkUrl()) return

        val b = Bitmap.createBitmap(binding.web.width, binding.web.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(b)
        binding.web.draw(canvas)

        vm.saveToDb(b, binding.web.url!!)
    }


}