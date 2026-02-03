package com.example.coffeebreaktime.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String = "",
    val password: String = ""
)