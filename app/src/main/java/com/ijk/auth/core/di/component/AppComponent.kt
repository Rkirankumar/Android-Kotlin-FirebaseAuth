package com.ijk.auth.core.di.component

import com.ijk.auth.core.di.module.AppModule
import com.ijk.auth.core.di.module.FirebaseModule
import com.ijk.auth.feature.login.LoginActivity
import com.ijk.auth.feature.MainActivity
import com.ijk.auth.ui.auth.presenter.AuthEmailPresenter
import com.ijk.auth.ui.auth.presenter.AuthGooglePresenter
import com.ijk.auth.ui.base.BottomNavigationDrawerFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(FirebaseModule::class, AppModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(bottomFragment: BottomNavigationDrawerFragment)
    fun inject(loginActivity: LoginActivity)
    fun inject(authPresenter: AuthEmailPresenter)
    fun inject(authPresenter: AuthGooglePresenter)
}