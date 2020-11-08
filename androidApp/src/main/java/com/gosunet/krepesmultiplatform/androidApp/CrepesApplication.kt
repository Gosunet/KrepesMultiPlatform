package com.gosunet.krepesmultiplatform.androidApp

import android.app.Application
import com.gosunet.krepesmultiplatform.androidApp.di.appModule
import com.gosunet.krepesmultiplatform.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent

class CrepesApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        @Suppress("EXPERIMENTAL_API_USAGE") // koin multiplatform experimental
        initKoin {
            modules(appModule)
            androidLogger()
            androidContext(this@CrepesApplication)
        }
    }
}
