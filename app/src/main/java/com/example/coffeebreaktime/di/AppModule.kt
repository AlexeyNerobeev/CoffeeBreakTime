package com.example.coffeebreaktime.di

import androidx.annotation.Size
import com.example.coffeebreaktime.data.repositoryImplementation.AdditivesRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.AuthRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.BaristaRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.CoffeeRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.CoffeeTypeRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.CountryRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.OrderRepositoryImpl
import com.example.coffeebreaktime.data.repositoryImplementation.ProfileRepositoryImpl
import com.example.coffeebreaktime.domain.UseCase.AuthUseCase
import com.example.coffeebreaktime.domain.UseCase.CreateProfileUseCase
import com.example.coffeebreaktime.domain.UseCase.GetBaristaListUseCase
import com.example.coffeebreaktime.domain.UseCase.GetCoffeeListUseCase
import com.example.coffeebreaktime.domain.UseCase.GetUserProfileUseCase
import com.example.coffeebreaktime.domain.UseCase.IsEmailValidUseCase
import com.example.coffeebreaktime.domain.UseCase.IsPasswordValidUseCase
import com.example.coffeebreaktime.domain.UseCase.RegistrationUseCase
import com.example.coffeebreaktime.domain.repository.AdditivesRepository
import com.example.coffeebreaktime.domain.repository.AuthRepository
import com.example.coffeebreaktime.domain.repository.BaristaRepository
import com.example.coffeebreaktime.domain.repository.CoffeeRepository
import com.example.coffeebreaktime.domain.repository.CoffeeTypeRepository
import com.example.coffeebreaktime.domain.repository.CountryRepository
import com.example.coffeebreaktime.domain.repository.OrderRepository
import com.example.coffeebreaktime.domain.repository.ProfileRepository
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
    fun provideCoffeeRepository(): CoffeeRepository{
        return CoffeeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepository{
        return ProfileRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideBaristaRepository(): BaristaRepository{
        return BaristaRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCountryRepository(): CountryRepository{
        return CountryRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCoffeeTypeRepository(): CoffeeTypeRepository{
        return CoffeeTypeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideAdditivesRepository(): AdditivesRepository{
        return AdditivesRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideOrderRepository(): OrderRepository{
        return OrderRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideGetBaristaListUseCase(
        baristaRepository: BaristaRepository
    ): GetBaristaListUseCase{
        return GetBaristaListUseCase(baristaRepository)
    }

    @Provides
    @Singleton
    fun provideGetUserProfileUseCase(
        profileRepository: ProfileRepository
    ): GetUserProfileUseCase{
        return GetUserProfileUseCase(profileRepository)
    }

    @Provides
    @Singleton
    fun provideCreateProfileUseCase(
        profileRepository: ProfileRepository
    ): CreateProfileUseCase{
        return CreateProfileUseCase(profileRepository)
    }

    @Provides
    @Singleton
    fun provideGetCoffeeListUseCase(
        coffeeRepository: CoffeeRepository
    ): GetCoffeeListUseCase{
        return GetCoffeeListUseCase(coffeeRepository)
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