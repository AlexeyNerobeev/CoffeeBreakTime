package com.example.coffeebreaktime.presentation.Authorization

data class AuthorizationState(
    val email: String = "",
    val password: String = "",
    val visualTransform: Boolean = true
)