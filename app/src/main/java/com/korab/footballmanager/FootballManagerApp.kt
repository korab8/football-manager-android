package com.korab.footballmanager

import android.app.Application
import com.korab.footballmanager.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * @author korab.muhadri
 */
class FootballManagerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FootballManagerApp)
            loadKoinModules(appModule)
        }
    }
}
