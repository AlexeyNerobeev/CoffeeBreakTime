package com.example.coffeebreaktime.domain.UseCase

import com.example.coffeebreaktime.domain.model.Profile
import com.example.coffeebreaktime.domain.repository.ProfileRepository

class CreateProfileUseCase(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(profile: Profile){
        profileRepository.createProfile(profile)
    }
}