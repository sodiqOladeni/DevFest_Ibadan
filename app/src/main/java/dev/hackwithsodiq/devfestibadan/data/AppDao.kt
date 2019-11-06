package dev.hackwithsodiq.devfestibadan.data

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.hackwithsodiq.devfestibadan.model.Schedule

@Dao
interface AppDao {

    @Query("select * from schedule_tb")
    fun allSchedules():LiveData<List<Schedule>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSchedule(schedule: Schedule):Long

    @Update
    fun updateSchedule(vararg schedule: Schedule)

    @Update
    fun deleteSchedule(vararg schedule: Schedule)
}