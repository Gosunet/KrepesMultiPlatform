package com.gosunet.krepesmultiplatform.shared.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import org.koin.core.KoinComponent

class CrepesApi(private val httpClient: HttpClient) : KoinComponent {

    private val baseApi = "https://u5iywk3bs4.execute-api.eu-west-3.amazonaws.com/Prod"
    private val apikey = "Ezc7yLacAz1V4OgIo9p191q76sS8fUqf0aVRQSl6"

    suspend fun getCrepes(): List<Crepe> = httpClient.get {
        url("$baseApi/crepes")
        headers {
            append("x-api-key", "apikey")
        }
    }

    suspend fun getGalettes(): List<Crepe> = httpClient.request {
        url("$baseApi/galettes")
        method = HttpMethod.Get
        headers {
            append("x-api-key", apikey)
        }
    }
}
