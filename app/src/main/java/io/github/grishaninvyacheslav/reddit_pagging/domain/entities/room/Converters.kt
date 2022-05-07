package io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.PostData

class Converters {
    @TypeConverter
    fun listToJson(value: List<PostData>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<PostData>::class.java).toList()
}