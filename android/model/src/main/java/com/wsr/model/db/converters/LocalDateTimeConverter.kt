package com.wsr.model.db.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object LocalDateTimeConverter {

    @JvmStatic
    @TypeConverter
    fun toLocalDateTime(value: String): LocalDateTime{
        return LocalDateTime.parse(value)
    }

    @JvmStatic
    @TypeConverter
    fun fromLocalDateTime(localDateTime: LocalDateTime): String{
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME)
    }
}
