package com.example.coffeebreaktime.data.dto

import com.example.coffeebreaktime.domain.model.Additives
import kotlinx.serialization.Serializable

@Serializable
data class AdditivesDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val description: String
) : Additives