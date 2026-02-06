package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.Profile
import com.example.coffeebreaktime.domain.model.User

interface ProfileRepository {
    suspend fun createProfile(profile: Profile)
    suspend fun getUserProfile(): Profile
}