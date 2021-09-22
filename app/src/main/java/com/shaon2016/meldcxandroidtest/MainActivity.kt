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
import java.lang.Exception


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        WebView.enableSlowWholeDocumentDraw();
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
    }

    private fun initWeb() {
        binding.web.webViewClient = WebViewClient()
        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true
    }

    private fun takeWebScreenshot() {
        binding.web.webViewClient =object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                val picture = view?.capturePicture()

                picture?.let {
                    val b = Bitmap.createBitmap(
                        picture.width,
                        picture.height, Bitmap.Config.ARGB_8888
                    )
                    val c = Canvas(b)

                    picture.draw(c)

                    // save bitmap to db
                }

            }
        }
    }


}