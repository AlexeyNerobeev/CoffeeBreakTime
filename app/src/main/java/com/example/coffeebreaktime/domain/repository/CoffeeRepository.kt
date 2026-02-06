package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.Coffee

interface CoffeeRepository {
    suspend fun getCoffeeList(): List<Coffee>
}