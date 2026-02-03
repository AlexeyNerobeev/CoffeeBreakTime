package com.example.coffeebreaktime.data.repositoryImplementation

import com.example.coffeebreaktime.data.Connect.Connect.supabase
import com.example.coffeebreaktime.domain.model.User
import com.example.coffeebreaktime.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class AuthRepositoryImpl: AuthRepository {
    override suspend fun auth(user: User) {
        supabase.auth.signInWith(Email){
            email = user.email
            password = user.password
        }
    }

    override suspend fun registration(user: User) {
        supabase.auth.signUpWith(Email){
            email = user.email
            password = user.password
        }
    }
}