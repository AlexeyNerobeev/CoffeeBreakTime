package com.example.coffeebreaktime.presentation.Registration

sealed class RegistrationEvent {
    data class EnteredName(val value: String): RegistrationEvent()
    data class EnteredPhone(val value: String): RegistrationEvent()
    data class EnteredEmail(val value: String): RegistrationEvent()
    data class EnteredPassword(val value: String): RegistrationEvent()
    data object Checked: RegistrationEvent()
    data object VisualChange: RegistrationEvent()
    data object SignUp: RegistrationEvent()
}