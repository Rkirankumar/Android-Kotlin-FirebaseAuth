package com.example.auth.core

import android.app.Application
import com.example.auth.core.di.component.AppComponent
import com.example.auth.core.di.module.FirebaseModule

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
                .firebaseModule(FirebaseModule())
                .build()
    }
}