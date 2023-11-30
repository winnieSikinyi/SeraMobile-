package com.greenrevive.serawaziapplication

import android.app.Application
import android.content.Context

class MyScenarios: Application() {
    companion object{
        lateinit var  appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}