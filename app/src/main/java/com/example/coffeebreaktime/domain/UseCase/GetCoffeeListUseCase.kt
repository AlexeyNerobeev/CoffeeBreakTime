package com.example.coffeebreaktime.domain.UseCase

import com.example.coffeebreaktime.domain.model.Coffee
import com.example.coffeebreaktime.domain.repository.CoffeeRepository

class GetCoffeeListUseCase(private val coffeeRepository: CoffeeRepository) {
    suspend operator fun invoke(): List<Coffee>{
        return coffeeRepository.getCoffeeList()
    }
}