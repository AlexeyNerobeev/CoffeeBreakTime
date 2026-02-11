package com.example.coffeebreaktime.presentation.MyOrder

import com.example.coffeebreaktime.domain.model.Order

data class MyOrderState(
    val orderList: List<Order> = listOf(),
    val error: Boolean = false,
    val load: Boolean = true,
    val total: Int = 0,
    val pay: Boolean = false,
    val name: String = "",
    val address: String = "",
    val selectSbp: Boolean = true,
    val selectBankCard: Boolean = false
)