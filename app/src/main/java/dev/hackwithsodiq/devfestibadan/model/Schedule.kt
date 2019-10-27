package dev.hackwithsodiq.devfestibadan.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_tb")
class Schedule {

    @PrimaryKey
    var scheduleId:String = ""
}