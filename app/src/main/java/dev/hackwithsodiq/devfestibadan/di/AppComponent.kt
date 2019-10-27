package dev.hackwithsodiq.devfestibadan.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import dev.hackwithsodiq.devfestibadan.MainApplication
import javax.inject.Singleton

@SuppressWarnings("unchecked")
@Singleton
@Component(modules = [DataModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: MainApplication)
}
