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
}