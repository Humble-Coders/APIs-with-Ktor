package com.yourbusiness.apiswithktor.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private const val BASE_URL = "https://official-joke-api.appspot.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .build()

    val jokeApi: JokeApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeApi::class.java)
}