package com.example.coffeebreaktime.domain.UseCase

import android.util.Patterns

class IsPasswordValidUseCase {
    operator fun invoke(password: String): Boolean{
        return password.length >= 9 &&
                password.any{it.isUpperCase()} &&
                password.any{it.isLowerCase()} &&
                password.any{it.isDigit()} &&
                password.any{it.isWhitespace()} &&
                password.any{!it.isLetterOrDigit() && !it.isWhitespace()}
    }
}