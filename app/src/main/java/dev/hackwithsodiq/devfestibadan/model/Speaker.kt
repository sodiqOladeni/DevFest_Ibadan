package dev.hackwithsodiq.devfestibadan.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "speaker_tb")
class Speaker {

    @PrimaryKey
    var speakerId:String = ""
}