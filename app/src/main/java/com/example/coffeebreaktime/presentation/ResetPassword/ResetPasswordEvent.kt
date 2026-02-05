package com.example.coffeebreaktime.presentation.ResetPassword

sealed class ResetPasswordEvent {
    data class EnteredPassword(val value: String): ResetPasswordEvent()
    data object VisualChange: ResetPasswordEvent()
}