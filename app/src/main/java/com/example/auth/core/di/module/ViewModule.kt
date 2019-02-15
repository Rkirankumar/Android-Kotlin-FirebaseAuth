package com.example.auth.core.di.module

import com.example.auth.core.base.BaseViewModel
import com.example.auth.domain.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module

@Module
interface ViewModule {
    @Binds
    fun provideLoginViewModel(loginViewModel: LoginViewModel) : BaseViewModel
}