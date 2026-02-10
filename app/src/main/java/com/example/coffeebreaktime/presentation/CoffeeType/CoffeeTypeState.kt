package com.example.coffeebreaktime.presentation.CoffeeType

import com.example.coffeebreaktime.domain.model.CoffeeType

data class CoffeeTypeState(
    val coffeeList: List<CoffeeType> = listOf(),
    val load: Boolean = true,
    val error: Boolean = false
)