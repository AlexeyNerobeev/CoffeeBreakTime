package com.example.coffeebreaktime.domain.UseCase

import com.example.coffeebreaktime.domain.model.User
import com.example.coffeebreaktime.domain.repository.AuthRepository

class RegistrationUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User){
        authRepository.registration(user)
    }
}