package com.yourbusiness.apiswithktor.api

import com.yourbusiness.apiswithktor.models.JokeResponse
import retrofit2.http.GET

interface JokeApi {
    @GET("random_joke")
    suspend fun getJoke(): JokeResponse
}