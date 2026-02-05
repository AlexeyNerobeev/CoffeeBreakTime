package com.example.coffeebreaktime.presentation.ForgotPassword

sealed class ForgotPasswordEvent {
    data class EnteredEmail(val value: String): ForgotPasswordEvent()
    data object ResetPassword: ForgotPasswordEvent()
    data object ErrorChange: ForgotPasswordEvent()
}