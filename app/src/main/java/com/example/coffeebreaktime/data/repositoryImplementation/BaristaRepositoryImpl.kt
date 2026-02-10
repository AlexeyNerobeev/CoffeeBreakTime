package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.Navigation
import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.data.dto.BaristaDto
import com.example.coffeebreaktime.domain.model.Barista
import com.example.coffeebreaktime.domain.repository.BaristaRepository
import io.github.jan.supabase.postgrest.postgrest

class BaristaRepositoryImpl: BaristaRepository {
    override suspend fun getBaristaList(): List<Barista> {
        return supabase.postgrest["barista"].select().decodeList<BaristaDto>()
    }
}