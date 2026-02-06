package com.example.coffeebreaktime.domain.UseCase

import com.example.coffeebreaktime.domain.model.Profile
import com.example.coffeebreaktime.domain.repository.ProfileRepository

class GetUserProfileUseCase(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(): Profile{
        return profileRepository.getUserProfile()
    }
}