package com.example.coffeebreaktime.presentation.Registration

data class RegistrationState(
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val checked: Boolean = false,
    val visualTransform: Boolean = true,
    val isComplete: Boolean = false
)