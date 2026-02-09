package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.Country

interface CountryRepository {
    suspend fun getCountryList(): List<Country>
}