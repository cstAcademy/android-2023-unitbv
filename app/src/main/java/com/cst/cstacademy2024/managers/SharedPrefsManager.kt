package com.cst.cstacademy2024.managers

import android.content.Context
import com.cst.cstacademy2024.ApplicationController

object SharedPrefsManager {

    private const val FILE_NAME = "cstacademy2024"

    private const val ARG_AUTH_TOKEN = "ARG_AUTH_TOKEN"

    private val sharedPrefs =
        ApplicationController.instance.applicationContext.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )

    fun writeToken(token: String) = write(ARG_AUTH_TOKEN, token)

    private fun write(key: String, value: String) = with(sharedPrefs.edit()) {
        putString(key, value)
        apply()
    }

    private fun write(key: String, value: Int) {

    }

    fun readToken() = readString(ARG_AUTH_TOKEN)

    private fun readString(key: String): String? = sharedPrefs.getString(key, null)
}