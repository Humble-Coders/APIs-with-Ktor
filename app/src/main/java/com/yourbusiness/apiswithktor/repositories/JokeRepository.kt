package com.yourbusiness.apiswithktor.repositories

import com.yourbusiness.apiswithktor.api.NetworkClient
import com.yourbusiness.apiswithktor.models.JokeResponse

class JokeRepository {
    private val api = NetworkClient.jokeApi

    suspend fun getJoke(): JokeResponse? {
        return try {
            api.getJoke()
        } catch (e: Exception) {
            null
        }
    }
}