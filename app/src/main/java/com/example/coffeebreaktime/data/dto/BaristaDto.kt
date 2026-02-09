package com.example.coffeebreaktime.data.dto

import com.example.coffeebreaktime.domain.model.Barista
import kotlinx.serialization.Serializable

@Serializable
data class BaristaDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val status: String
) : Barista