package com.yourbusiness.apiswithktor.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkClient {
    private const val BASE_URL = "https://official-joke-api.appspot.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout( 30, TimeUnit.SECONDS)
        .build()

    val jokeApi: JokeApi = Retrofit.Builder() // implementation for all
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeApi::class.java)
}

// google - retrofit

// JSON - Java Script Object Notation