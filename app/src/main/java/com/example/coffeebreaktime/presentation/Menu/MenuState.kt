package com.example.coffeebreaktime.presentation.Menu

import com.example.coffeebreaktime.domain.model.Coffee

data class MenuState(
    val userName: String = "",
    val coffeeList: List<Coffee> = listOf(),
    val load: Boolean = true
)