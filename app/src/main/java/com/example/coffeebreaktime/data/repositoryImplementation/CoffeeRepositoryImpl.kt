package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.domain.model.Coffee
import com.example.coffeebreaktime.domain.repository.CoffeeRepository
import io.github.jan.supabase.postgrest.postgrest

class CoffeeRepositoryImpl: CoffeeRepository {
    override suspend fun getCoffeeList(): List<Coffee> {
        return supabase.postgrest["coffee"].select().decodeList<Coffee>()
    }

}