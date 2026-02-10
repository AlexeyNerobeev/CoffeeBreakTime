package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.CoffeeType

interface CoffeeTypeRepository {
    suspend fun getCoffeeTypeList(): List<CoffeeType>
}