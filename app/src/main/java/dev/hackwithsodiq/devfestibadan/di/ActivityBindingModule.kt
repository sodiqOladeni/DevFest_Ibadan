package dev.hackwithsodiq.devfestibadan.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.hackwithsodiq.devfestibadan.view.MainActivity

@Suppress("unused")
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun mainFtue(): MainActivity
}