package dev.hackwithsodiq.devfestibadan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.hackwithsodiq.devfestibadan.model.Schedule
import dev.hackwithsodiq.devfestibadan.model.Speaker
import dev.hackwithsodiq.devfestibadan.model.Team

@Database(entities = [Schedule::class, Speaker::class, Team::class], version = 1)
abstract class AppDb:RoomDatabase() {
    abstract val dao:AppDao
    companion object{
        private lateinit var INSTANCE: AppDb

        fun getDatabase(context: Context): AppDb {
            synchronized(AppDb::class.java) {
                if (!Companion::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDb::class.java,
                        "App_Database").build()
                }
            }
            return INSTANCE
        }
    }
}