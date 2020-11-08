package com.gosunet.krepesmultiplatform.shared.di

import com.gosunet.krepesmultiplatform.shared.data.CrepesApi
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.util.KtorExperimentalAPI
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

@KtorExperimentalAPI
fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, networkingModule)
}

// called by iOS etc
@KtorExperimentalAPI
fun initKoin() = initKoin {}

@KtorExperimentalAPI
val networkingModule = module {
    single {
        HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}

val commonModule = module {
    single { CrepesApi(get()) }
    single { CrepesRepository(get()) }
}
