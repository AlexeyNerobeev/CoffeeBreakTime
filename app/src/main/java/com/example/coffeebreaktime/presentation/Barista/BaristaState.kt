package com.example.coffeebreaktime.presentation.Barista

import com.example.coffeebreaktime.domain.model.Barista

data class BaristaState(
    val baristaList: List<Barista> = listOf(),
    val load: Boolean = true
)