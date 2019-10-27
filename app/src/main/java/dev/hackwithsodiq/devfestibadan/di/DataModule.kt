package dev.hackwithsodiq.devfestibadan.di

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dev.hackwithsodiq.devfestibadan.data.AppDb
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class DataModule {

    @Singleton
    @Provides
    fun provideFirestore():FirebaseFirestore = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun provideDatabase(app: Application):AppDb = AppDb.getDatabase(app)

    @Singleton
    @Provides
    fun provideDao(app: Application) = AppDb.getDatabase(app).dao

}