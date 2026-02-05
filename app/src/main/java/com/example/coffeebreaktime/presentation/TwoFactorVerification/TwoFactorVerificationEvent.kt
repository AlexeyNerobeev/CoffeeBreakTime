package com.example.coffeebreaktime.presentation.TwoFactorVerification

sealed class TwoFactorVerificationEvent {
    data class EnteredFirstNum(val value: String): TwoFactorVerificationEvent()
    data class EnteredSecondNum(val value: String): TwoFactorVerificationEvent()
    data class EnteredThirdNum(val value: String): TwoFactorVerificationEvent()
    data class EnteredFourthNum(val value: String): TwoFactorVerificationEvent()
    data object ChangeError: TwoFactorVerificationEvent()
    data object GoNext: TwoFactorVerificationEvent()
}