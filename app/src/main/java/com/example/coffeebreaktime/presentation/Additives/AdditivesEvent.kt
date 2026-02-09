package com.example.coffeebreaktime.presentation.Additives

sealed class AdditivesEvent {
    data object ChangeError: AdditivesEvent()
}