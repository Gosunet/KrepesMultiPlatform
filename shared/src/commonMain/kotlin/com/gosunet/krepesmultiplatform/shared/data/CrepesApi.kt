package com.gosunet.krepesmultiplatform.shared.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

class CrepesApi(private val httpClient: HttpClient) : KoinComponent {

    private val baseApi = "https://u5iywk3bs4.execute-api.eu-west-3.amazonaws.com/Prod"
    private val apikey = "Ezc7yLacAz1V4OgIo9p191q76sS8fUqf0aVRQSl6"

    suspend fun getCrepes(): List<Crepe> = httpClient.get("$baseApi/crepes") {
        headers {
            append("x-api-key", "apikey")
        }
    }.body()

    suspend fun getGalettes(): List<Crepe> = httpClient.get("$baseApi/galettes") {
        headers {
            append("x-api-key", apikey)
        }
    }.body()
}
