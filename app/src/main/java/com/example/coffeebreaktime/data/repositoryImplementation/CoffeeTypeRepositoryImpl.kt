package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.data.dto.CoffeeTypeDto
import com.example.coffeebreaktime.domain.model.CoffeeType
import com.example.coffeebreaktime.domain.repository.CoffeeTypeRepository
import io.github.jan.supabase.postgrest.postgrest

class CoffeeTypeRepositoryImpl: CoffeeTypeRepository {
    override suspend fun getCoffeeTypeList(): List<CoffeeType> {
        return supabase.postgrest["coffee_type"].select().decodeList<CoffeeTypeDto>()
    }

}