package com.example.coffeebreaktime.presentation.ResetPassword

sealed class ResetPasswordEvent {
    data class EnteredPassword(val value: String): ResetPasswordEvent()
    data object VisualChange: ResetPasswordEvent()
    data object ErrorChange: ResetPasswordEvent()
    data object PasswordChange: ResetPasswordEvent()
}