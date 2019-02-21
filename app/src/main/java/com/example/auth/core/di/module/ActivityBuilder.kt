package com.example.auth.core.di.module

import com.example.auth.feature.login.LoginActivity
import com.example.auth.feature.signup.SignUpActivity
import com.example.auth.feature.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [ViewModule::class])
    fun contributeLoginActivity(): LoginActivity
    
    @ContributesAndroidInjector(modules = [ViewModule::class])
    fun contributeSplashActivity(): SplashActivity
    
    @ContributesAndroidInjector(modules = [ViewModule::class])
    fun contributeSignUpActivity(): SignUpActivity
}