package com.example.coffeebreaktime.presentation.OrderOptions

sealed class OrderOptionsEvent {
    data object PlusCount: OrderOptionsEvent()
    data object MinusCount: OrderOptionsEvent()
    data object SwitchChange: OrderOptionsEvent()
}