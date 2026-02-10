package com.example.coffeebreaktime.domain.model

interface Order {
    val id: Int
    val image: String
    val name: String
    val description: String
    val count: Int
    val sum: Int
}