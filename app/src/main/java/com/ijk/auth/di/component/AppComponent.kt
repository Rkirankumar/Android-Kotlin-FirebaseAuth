package com.ijk.auth.di.component

import com.ijk.auth.di.module.AppModule
import com.ijk.auth.di.module.FirebaseModule
import com.ijk.auth.ui.base.MainActivity
import com.ijk.auth.ui.login.presenter.AuthEmailAndPasswordPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(FirebaseModule::class, AppModule::class))
interface AppComponent {

    fun inject(authEmailAndPasswordPresenter: AuthEmailAndPasswordPresenter)
    fun inject(mainActivity: MainActivity)
}