package com.example.auth.core.di.module

import com.example.auth.feature.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [ViewModule::class])
    fun contributeLoginActivity(): LoginActivity
}