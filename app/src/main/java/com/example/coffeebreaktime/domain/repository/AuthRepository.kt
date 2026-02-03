package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.User

interface AuthRepository {
    suspend fun registration(user: User)
    suspend fun auth(user: User)
}