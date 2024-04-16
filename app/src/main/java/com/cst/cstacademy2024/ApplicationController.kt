package com.cst.cstacademy2024

import android.app.Application
import androidx.room.Room
import com.cst.cstacademy2024.data.AppDatabase

class ApplicationController : Application() {

    lateinit var appDatabase: AppDatabase
        private set

    companion object {
        lateinit var instance: ApplicationController
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        setUpDatabase()
    }


    private fun setUpDatabase() {
        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "cst-academy-db"
        ).build()

    }
}