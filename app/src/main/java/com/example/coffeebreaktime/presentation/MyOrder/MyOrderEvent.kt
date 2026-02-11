package com.example.coffeebreaktime.presentation.MyOrder

sealed class MyOrderEvent {
    data object ChangeError: MyOrderEvent()
    data object Pay: MyOrderEvent()
    data object SelectSbp: MyOrderEvent()
    data object SelectBankCard: MyOrderEvent()
}