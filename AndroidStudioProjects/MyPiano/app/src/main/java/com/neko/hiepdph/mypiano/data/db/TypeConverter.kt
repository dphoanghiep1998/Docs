package com.neko.hiepdph.mypiano.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.neko.hiepdph.mypiano.data.model.AutoPlayEntity
import java.lang.reflect.Type


class TypeConverter {
    @TypeConverter
    fun fromAutoEntityToJSON(listAutoPlayEntity: List<AutoPlayEntity>): String {
        return Gson().toJson(listAutoPlayEntity)
    }

    @TypeConverter
    fun fromJSONtoAutoEntity(json: String): List<AutoPlayEntity> {
        val listType: Type = object : TypeToken<List<AutoPlayEntity?>?>() {}.type
        return Gson().fromJson(json, listType)
    }
}