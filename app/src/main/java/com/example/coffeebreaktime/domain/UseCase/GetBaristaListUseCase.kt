package com.example.coffeebreaktime.domain.UseCase

import com.example.coffeebreaktime.domain.model.Barista
import com.example.coffeebreaktime.domain.repository.BaristaRepository

class GetBaristaListUseCase(private val baristaRepository: BaristaRepository) {
    suspend operator fun invoke(): List<Barista>{
        return baristaRepository.getBaristaList()
    }
}