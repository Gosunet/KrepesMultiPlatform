package com.gosunet.krepesmultiplatform.shared.di

import com.gosunet.krepesmultiplatform.shared.data.CrepesApi
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS etc
fun initKoin() = initKoin {}

val commonModule = module {
    single { CrepesApi() }
    single { CrepesRepository() }
}
