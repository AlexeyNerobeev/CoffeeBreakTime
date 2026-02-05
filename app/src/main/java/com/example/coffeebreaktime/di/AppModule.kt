package com.example.coffeebreaktime.di

import androidx.annotation.Size
import com.example.coffeebreaktime.data.repositoryImplementation.AuthRepositoryImpl
import com.example.coffeebreaktime.domain.UseCase.AuthUseCase
import com.example.coffeebreaktime.domain.UseCase.IsEmailValidUseCase
import com.example.coffeebreaktime.domain.UseCase.IsPasswordValidUseCase
import com.example.coffeebreaktime.domain.UseCase.RegistrationUseCase
import com.example.coffeebreaktime.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository{
        return AuthRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(
        authRepository: AuthRepository
    ): AuthUseCase{
        return AuthUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideRegistrationUseCase(
        authRepository: AuthRepository
    ): RegistrationUseCase{
        return RegistrationUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideIsPasswordValidUseCase(): IsPasswordValidUseCase{
        return IsPasswordValidUseCase()
    }

    @Provides
    @Singleton
    fun provideIsEmailValidUseCase(): IsEmailValidUseCase{
        return IsEmailValidUseCase()
    }
}