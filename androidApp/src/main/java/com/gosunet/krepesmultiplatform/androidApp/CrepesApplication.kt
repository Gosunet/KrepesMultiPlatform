package com.gosunet.krepesmultiplatform.androidApp

import android.app.Application
import com.gosunet.krepesmultiplatform.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent

class CrepesApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@CrepesApplication)
        }
    }
}
