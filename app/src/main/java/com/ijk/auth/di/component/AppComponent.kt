package com.ijk.auth.di.component

import com.ijk.auth.di.module.AppModule
import com.ijk.auth.di.module.FirebaseModule
import com.ijk.auth.ui.auth.LoginActivity
import com.ijk.auth.ui.base.MainActivity
import com.ijk.auth.ui.auth.presenter.AuthEmailPresenter
import com.ijk.auth.ui.auth.presenter.AuthGooglePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(FirebaseModule::class, AppModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(authPresenter: AuthEmailPresenter)
    fun inject(authPresenter: AuthGooglePresenter)
}