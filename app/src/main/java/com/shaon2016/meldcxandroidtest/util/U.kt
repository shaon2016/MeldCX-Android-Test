package com.shaon2016.meldcxandroidtest.util

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.view.inputmethod.InputMethodManager
import java.io.ByteArrayOutputStream

object U {
    /**
     * Hide keyboard pop up
     * */
    fun hideKeyboard(context: Context) {
        val inputManager = context.getSystemService(
            Context.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        val focusedView = (context as Activity).currentFocus

        if (focusedView != null) {
            inputManager.hideSoftInputFromWindow(
                focusedView.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    /**
     * Converts a bitmap to byte array
     * */
    fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream)
        val byteArray = stream.toByteArray()
        bitmap.recycle()

        return byteArray
    }
}