package com.example.coffeebreaktime.presentation.TwoFactorVerification

data class TwoFactorVerificationState(
    val firstNum: String = "",
    val secondNum: String = "",
    val thirdNum: String = "",
    val fourthNum: String = "",
    val seconds: Int = 30,
    val error: Boolean = false,
    val next: Boolean = false
)