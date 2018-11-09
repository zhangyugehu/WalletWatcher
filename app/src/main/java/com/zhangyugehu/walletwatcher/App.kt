package com.zhangyugehu.walletwatcher

import android.app.Application
import org.litepal.LitePal

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
    }
}
