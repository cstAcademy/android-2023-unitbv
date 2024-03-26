package com.cst.cstacademy2024

import android.app.Application

class ApplicationController: Application(){
    companion object {
        lateinit var instance: ApplicationController
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}