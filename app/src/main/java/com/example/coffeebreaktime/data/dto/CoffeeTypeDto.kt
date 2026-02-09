package com.example.coffeebreaktime.data.dto

import com.example.coffeebreaktime.domain.model.CoffeeType
import kotlinx.serialization.Serializable

@Serializable
data class CoffeeTypeDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val description: String
) : CoffeeType
