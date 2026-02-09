package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.data.dto.AdditivesDto
import com.example.coffeebreaktime.domain.model.Additives
import com.example.coffeebreaktime.domain.repository.AdditivesRepository
import io.github.jan.supabase.postgrest.postgrest

class AdditivesRepositoryImpl: AdditivesRepository {
    override suspend fun getAdditivesList(): List<Additives> {
        return supabase.postgrest["additives"].select().decodeList<AdditivesDto>()
    }
}