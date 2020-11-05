package com.gosunet.krepesmultiplatform.shared.di

import com.gosunet.krepesmultiplatform.shared.data.CrepesApi
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.util.KtorExperimentalAPI
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, networkingModule)
}

// called by iOS etc
fun initKoin() = initKoin {}

@KtorExperimentalAPI
val networkingModule = module {
    single { HttpClient(CIO) }
}

val commonModule = module {
    single { CrepesApi(get()) }
    single { CrepesRepository(get()) }
}
