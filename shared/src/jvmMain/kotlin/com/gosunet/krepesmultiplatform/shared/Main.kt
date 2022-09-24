package com.gosunet.krepesmultiplatform.shared

import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import com.gosunet.krepesmultiplatform.shared.di.initKoin
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val koin = initKoin().koin
        val api = koin.get<CrepesRepository>()
        println(api.getCrepes())
    }
}
