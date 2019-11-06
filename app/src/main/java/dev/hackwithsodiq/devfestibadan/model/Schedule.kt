package dev.hackwithsodiq.devfestibadan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.Timestamp

@Entity(tableName = "schedule_tb")
data class Schedule(
    @PrimaryKey
    var scheduleId: String = "",
    var topic: String = "",
    var time:Timestamp? = null,
    var speakerAvatar:String? = "",
    var speakerName:String = "",
    var speakerTag:String = "",
    var tracks:List<String> = emptyList(),
    var track:String = "",
    var orderInTheList:Int = -1
)