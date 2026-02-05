package com.example.coffeebreaktime.common

data class VerificationTfData(
    val value: String,
    val onValueChange: (String) -> Unit,
    val padding: Int
)