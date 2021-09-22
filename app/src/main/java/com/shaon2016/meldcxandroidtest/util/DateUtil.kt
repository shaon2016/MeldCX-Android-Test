package com.shaon2016.meldcxandroidtest.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    private const val appViewDateFormat = "dd-MM-yyyy"

    val todayDateForView: String
        get() {
            val formatter = SimpleDateFormat(appViewDateFormat, Locale.US)
            val date = Date()
            return formatter.format(date)
        }
}