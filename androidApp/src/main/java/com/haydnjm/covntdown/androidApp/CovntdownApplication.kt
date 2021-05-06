package com.haydnjm.covntdown.androidApp

import android.app.Application
import com.haydnjm.covntdown.androidApp.di.appModule
import com.haydnjm.covntdown.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class CovntdownApplication: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@CovntdownApplication)
            modules(appModule)
        }
    }
}