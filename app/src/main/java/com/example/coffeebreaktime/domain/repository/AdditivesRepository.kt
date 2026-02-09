package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.Additives

interface AdditivesRepository {
    suspend fun getAdditivesList(): List<Additives>
}