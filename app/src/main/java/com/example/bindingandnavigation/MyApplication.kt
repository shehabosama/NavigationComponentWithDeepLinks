package com.example.bindingandnavigation

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import cat.ereza.customactivityoncrash.config.CaocConfig

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        CaocConfig.Builder.create()
            .trackActivities(true).showErrorDetails(true)
            .errorActivity(ErrorActivity::class.java)
            .apply()
    }




}