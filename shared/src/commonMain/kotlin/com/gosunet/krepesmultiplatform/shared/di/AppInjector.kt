package com.gosunet.krepesmultiplatform.shared.di

import com.gosunet.krepesmultiplatform.shared.data.CrepesApi
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule())
}

// called by iOS etc
fun initKoin() = initKoin {}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun commonModule() = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single { CoroutineScope(Dispatchers.Default + SupervisorJob() ) }
    single { CrepesApi(get()) }
    single { CrepesRepository() }
}

fun createHttpClient(json: Json) =
    HttpClient {
        install(ContentNegotiation) {
            json(json)
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
