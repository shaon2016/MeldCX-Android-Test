package com.shaon2016.meldcxandroidtest.util

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

object DateUtil {
    private const val appViewDateFormat = "dd-MM-yyyy HH:mm"

    /**
     * Returns a formatted date time
     * */
    val todayDateTimeForView: String
        get() {
            val formatter = SimpleDateFormat(appViewDateFormat, Locale.US)
            val date = Date()
            return formatter.format(date)
        }

}