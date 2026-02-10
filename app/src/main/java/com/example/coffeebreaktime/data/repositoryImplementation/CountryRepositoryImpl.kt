package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.data.dto.CountryDto
import com.example.coffeebreaktime.domain.model.Country
import com.example.coffeebreaktime.domain.repository.CountryRepository
import io.github.jan.supabase.postgrest.postgrest

class CountryRepositoryImpl: CountryRepository {
    override suspend fun getCountryList(): List<Country> {
        return supabase.postgrest["country"].select().decodeList<CountryDto>()
    }
}