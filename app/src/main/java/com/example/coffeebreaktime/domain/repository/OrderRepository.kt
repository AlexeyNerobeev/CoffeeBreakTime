package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.domain.model.Order

interface OrderRepository {
    suspend fun getOrderList(): List<Order>
}