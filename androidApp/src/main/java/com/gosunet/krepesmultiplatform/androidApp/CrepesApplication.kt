package com.gosunet.krepesmultiplatform.androidApp

import android.app.Application
import com.gosunet.krepesmultiplatform.androidApp.di.appModule
import com.gosunet.krepesmultiplatform.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class CrepesApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@CrepesApplication)
            androidLogger()
            modules(appModule)
        }
    }
}
