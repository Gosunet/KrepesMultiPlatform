package com.gosunet.krepesmultiplatform.shared.data

import org.koin.core.KoinComponent

class CrepesRepository(private val crepesApi: CrepesApi): KoinComponent {
    suspend fun getCrepes() = crepesApi.getCrepes()
    suspend fun getGalettes() = crepesApi.getGalettes()
}
