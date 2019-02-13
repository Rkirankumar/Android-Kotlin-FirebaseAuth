package com.example.auth.core.di.component

import com.example.auth.core.di.module.FirebaseModule
import com.example.auth.feature.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FirebaseModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}