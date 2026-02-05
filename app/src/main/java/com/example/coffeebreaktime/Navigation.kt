package com.example.coffeebreaktime

import kotlinx.serialization.Serializable

sealed class Navigation {
    @Serializable
    data object WelcomeScreen: Navigation()

    @Serializable
    data object AuthorizationScreen: Navigation()

    @Serializable
    data object RegistrationScreen: Navigation()

    @Serializable
    data object StartUpScreen: Navigation()

    @Serializable
    data object ForgotPassword: Navigation()

    @Serializable
    data object TwoFactorVerification: Navigation()

    @Serializable
    data object ResetPassword: Navigation()

    @Serializable
    data object Menu: Navigation()

    @Serializable
    data object CafeScreen: Navigation()
}