package com.candidate.servando.sharedresources

import android.util.Log

object ExceptionLogger {
    fun log(throwable: Throwable?) {
        if (throwable != null) {
            Log.e("ExceptionLogger", throwable.message, throwable)
        }
    }
}