package com.zxj.wukong

import android.app.Application

class BaseApplication:Application() {
    companion object{
        lateinit var instance:Application
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}