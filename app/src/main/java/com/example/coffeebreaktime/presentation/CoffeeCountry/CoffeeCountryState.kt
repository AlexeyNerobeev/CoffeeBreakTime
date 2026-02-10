package com.example.coffeebreaktime.presentation.CoffeeCountry

import com.example.coffeebreaktime.domain.model.Country

data class CoffeeCountryState(
    val countryLis: List<Country> = listOf(),
    val load: Boolean = true
)