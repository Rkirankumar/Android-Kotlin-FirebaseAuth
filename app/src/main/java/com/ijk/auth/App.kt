package com.ijk.auth

import android.app.Application
import com.ijk.auth.di.component.AppComponent
import com.ijk.auth.di.component.DaggerAppComponent
import com.ijk.auth.di.module.AppModule
import com.ijk.auth.di.module.FirebaseModule

class App : Application() {

    companion object {

        private lateinit var mAppComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return mAppComponent
        }
    }

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .firebaseModule(FirebaseModule())
                .build()

    }

}