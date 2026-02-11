package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.data.dto.OrderDto
import com.example.coffeebreaktime.domain.model.Order
import com.example.coffeebreaktime.domain.repository.OrderRepository
import io.github.jan.supabase.postgrest.postgrest

class OrderRepositoryImpl: OrderRepository {
    override suspend fun getOrderList(): List<Order> {
        return supabase.postgrest["order"].select().decodeList<OrderDto>()
    }

}