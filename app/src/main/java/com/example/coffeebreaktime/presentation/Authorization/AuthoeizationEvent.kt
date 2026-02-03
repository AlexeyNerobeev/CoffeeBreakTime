package com.example.coffeebreaktime.presentation.Authorization

sealed class AuthorizationEvent {
    data class EnteredEmail(val value: String): AuthorizationEvent()
    data class EnteredPassword(val value: String): AuthorizationEvent()
    data object VisualChange: AuthorizationEvent()
    data object SignIn: AuthorizationEvent()
}