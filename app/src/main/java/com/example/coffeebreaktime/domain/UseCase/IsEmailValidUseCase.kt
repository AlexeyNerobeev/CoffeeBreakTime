package com.example.coffeebreaktime.domain.UseCase

import android.util.Patterns

class IsEmailValidUseCase {
    operator fun invoke(email: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}