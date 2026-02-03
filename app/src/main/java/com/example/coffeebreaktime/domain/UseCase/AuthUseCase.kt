package com.example.coffeebreaktime.domain.UseCase

import com.example.coffeebreaktime.domain.model.User
import com.example.coffeebreaktime.domain.repository.AuthRepository

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User){
        authRepository.auth(user)
    }
}