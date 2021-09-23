package com.shaon2016.meldcxandroidtest

import android.webkit.URLUtil
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class MainActivityTest {

    /**
     * Checking url validation that start with http or https
     * */
    @Test
    fun checkUrl_ReturnTrue() {
        val url = "https://www.google.com"

        val isValid = url.isNotEmpty() && url.startsWith("http")

        assertThat(isValid, `is`(true))
    }


}