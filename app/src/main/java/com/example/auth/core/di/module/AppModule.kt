package com.example.auth.core.di.module

import com.example.auth.domain.repository.CheckoutRepository
import com.example.auth.domain.repository.CheckoutRepositoryImpl
import com.example.auth.domain.repository.UserRepository
import com.example.auth.domain.repository.UserRepositoryImpl
import com.example.auth.module.firebase.FirebaseSource
import com.example.auth.module.firebase.FirebaseSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppModule {
    @Binds
    @Singleton
    fun provideFirebaseSource(firebaseSourceImpl: FirebaseSourceImpl): FirebaseSource
    
    @Binds
    @Singleton
    fun provideCheckoutRepository(
        checkoutRepositoryImpl: CheckoutRepositoryImpl): CheckoutRepository
    
    @Binds
    @Singleton
    fun provideUserRepository(
        checkoutRepositoryImpl: UserRepositoryImpl): UserRepository
}