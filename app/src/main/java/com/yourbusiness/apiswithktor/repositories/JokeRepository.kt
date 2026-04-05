package com.yourbusiness.apiswithktor.repositories

import com.yourbusiness.apiswithktor.api.NetworkClient
import com.yourbusiness.apiswithktor.models.JokeResponse

class JokeRepository {

    suspend fun getJoke(): JokeResponse? {
        return try {
            NetworkClient.jokeApi.getJoke()
        } catch (e: Exception) {
            null
        }
    }
}