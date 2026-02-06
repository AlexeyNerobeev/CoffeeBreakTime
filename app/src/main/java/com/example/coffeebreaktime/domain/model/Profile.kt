package com.example.coffeebreaktime.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: Int = 0,
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val address: String = "",
    val user_id: String = ""
)