package com.example.coffeebreaktime.presentation.ResetPassword

data class ResetPasswordState(
    val password: String = "",
    val visualTransform: Boolean = true,
    val error: Boolean = false,
    val isComplete: Boolean = false
)