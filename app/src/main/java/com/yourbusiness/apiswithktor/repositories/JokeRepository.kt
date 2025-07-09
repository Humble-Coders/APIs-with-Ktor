package com.yourbusiness.apiswithktor.repositories

import com.yourbusiness.apiswithktor.models.JokeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class JokeRepository {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {  // just a plugin needed by ktor
            json()
        }
    }

    suspend fun getJoke(): JokeResponse {
        return client.get("https://official-joke-api.appspot.com/random_joke").body() // .body is the converter
    }
}