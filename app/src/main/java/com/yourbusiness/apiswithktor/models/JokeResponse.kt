package com.yourbusiness.apiswithktor.models

import kotlinx.serialization.Serializable

data class JokeResponse(
    val setup: String,
    val punchline: String
)