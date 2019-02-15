package com.example.auth.core.di.component

import android.content.Context
import com.example.auth.core.App
import com.example.auth.core.di.module.ActivityBuilder
import com.example.auth.core.di.module.AppModule
import com.example.auth.core.di.module.ViewModule
import com.example.auth.feature.login.LoginActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ViewModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        
        fun build(): AppComponent
    }
    
    override fun inject(app: App)
}