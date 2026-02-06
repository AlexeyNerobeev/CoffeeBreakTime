package com.example.coffeebreaktime.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Coffee(
    val id: Int = 0,
    val name: String = "",
    val price: Int = 0,
    val image: String = ""
)
