package com.example.auth.core.di.module

import com.example.auth.domain.repository.CheckoutRepository
import com.example.auth.domain.repository.CheckoutRepositoryImpl
import com.example.auth.module.FirebaseSource
import com.example.auth.module.FirebaseSourceImpl
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
}