package com.rvery.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RVeryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}