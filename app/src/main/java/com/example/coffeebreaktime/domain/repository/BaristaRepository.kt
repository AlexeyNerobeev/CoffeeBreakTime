package com.example.coffeebreaktime.domain.repository

import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.domain.model.Barista

interface BaristaRepository {
    suspend fun getBaristaList(): List<Barista>
}