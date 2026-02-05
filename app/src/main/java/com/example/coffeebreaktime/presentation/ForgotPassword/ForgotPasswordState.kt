package com.example.coffeebreaktime.presentation.ForgotPassword

data class ForgotPasswordState(
    val email: String = "",
    val isComplete: Boolean = false,
    val error: Boolean = false
)