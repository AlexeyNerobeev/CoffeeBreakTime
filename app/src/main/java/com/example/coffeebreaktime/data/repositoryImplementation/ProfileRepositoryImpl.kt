package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.domain.model.Profile
import com.example.coffeebreaktime.domain.model.User
import com.example.coffeebreaktime.domain.repository.ProfileRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest

class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun createProfile(profile: Profile) {
        val newProfile = Profile(name = profile.name,
            phone = profile.phone,
            email = profile.email,
            user_id = getUserId())
        supabase.postgrest["profile"].insert(newProfile)
    }

    override suspend fun getUserProfile(): Profile {
        return supabase.postgrest["profile"].select(){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Profile>()
    }

    suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?: ""
    }
}