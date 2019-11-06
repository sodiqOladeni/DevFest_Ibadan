package dev.hackwithsodiq.devfestibadan.data

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.firebase.Timestamp
import com.google.gson.Gson



class Converters {

    @TypeConverter
    fun fromTagsToJson(tags: List<String>?):String?{
        return Gson().toJson(tags)
    }

    @TypeConverter
    fun fromJsonToTags(userJson: String?):List<String>?{
        return Gson().fromJson(userJson, Array<String>::class.java).toList()
    }

    @TypeConverter
    fun fromTimeStampToJson(time: Timestamp?):String?{
        return Gson().toJson(time)
    }

    @TypeConverter
    fun fromJsonToTimeStamp(time: String?):Timestamp?{
        return Gson().fromJson(time, Timestamp::class.java)
    }
}