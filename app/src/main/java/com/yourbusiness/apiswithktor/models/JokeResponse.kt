package com.yourbusiness.apiswithktor.models

import kotlinx.serialization.Serializable

@Serializable
data class JokeResponse(
    val type: String,
    val setup: String,
    val punchline: String,
    val id: Int
)