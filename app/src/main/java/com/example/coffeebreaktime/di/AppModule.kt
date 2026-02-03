package com.example.coffeebreaktime.di

import com.example.coffeebreaktime.data.repositoryImplementation.AuthRepositoryImpl
import com.example.coffeebreaktime.domain.UseCase.AuthUseCase
import com.example.coffeebreaktime.domain.UseCase.RegistrationUseCase
import com.example.coffeebreaktime.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository{
        return AuthRepositoryImpl()
    }

    @Provides
    fun provideAuthUseCase(
        authRepository: AuthRepository
    ): AuthUseCase{
        return AuthUseCase(authRepository)
    }

    @Provides
    fun provideRegistrationUseCase(
        authRepository: AuthRepository
    ): RegistrationUseCase{
        return RegistrationUseCase(authRepository)
    }
}