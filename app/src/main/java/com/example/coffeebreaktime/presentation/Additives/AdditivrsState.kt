package com.example.coffeebreaktime.presentation.Additives

import com.example.coffeebreaktime.domain.model.Additives

data class AdditivesState(
    val additivesList: List<Additives> = listOf(),
    val load: Boolean = true,
    val error: Boolean = false
)
