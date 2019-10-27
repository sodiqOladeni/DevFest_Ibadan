package dev.hackwithsodiq.devfestibadan.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_tb")
class Team {

    @PrimaryKey
    var teamId:String = ""
}