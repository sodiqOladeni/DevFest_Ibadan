package dev.hackwithsodiq.devfestibadan.model

data class Team (
    var name: String,
    var role: String,
    var imageLink:String? = null,
    var position:Int,
    var twitter: String,
    var webLink:String? = null
    )