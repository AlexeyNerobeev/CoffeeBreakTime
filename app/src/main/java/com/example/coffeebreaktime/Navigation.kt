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

    @Serializable
    data object Profile: Navigation()

    @Serializable
    data object MyOrderCurrent: Navigation()

    @Serializable
    data object Reward: Navigation()

    @Serializable
    data object OrderOptions: Navigation()

    @Serializable
    data object Designer: Navigation()

    @Serializable
    data object Barista: Navigation()

    @Serializable
    data object Country: Navigation()

    @Serializable
    data object CoffeeTypeScreen: Navigation()

    @Serializable
    data object AdditivesScreen: Navigation()
}