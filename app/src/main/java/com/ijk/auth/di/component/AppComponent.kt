package com.ijk.auth.di.component

import com.ijk.auth.di.module.AppModule
import com.ijk.auth.di.module.FirebaseModule
import com.ijk.auth.mvp.MainActivity
import com.ijk.auth.mvp.presenter.AuhtDataPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(FirebaseModule::class, AppModule::class))
interface AppComponent {

    fun inject(auhtDataPresenter: AuhtDataPresenter)
    fun inject(mainActivity: MainActivity)
}