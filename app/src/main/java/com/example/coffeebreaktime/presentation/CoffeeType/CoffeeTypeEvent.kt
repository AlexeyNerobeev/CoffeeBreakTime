package com.example.coffeebreaktime.presentation.CoffeeType

sealed class CoffeeTypeEvent {
    data object ChangeError: CoffeeTypeEvent()
}