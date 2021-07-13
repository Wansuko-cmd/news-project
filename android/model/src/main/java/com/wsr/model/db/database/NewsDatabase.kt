package com.wsr.model.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wsr.model.db.converters.LocalDateTimeConverter
import com.wsr.model.db.dao.FavoriteDao
import com.wsr.model.db.entities.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateTimeConverter::class)
abstract class NewsDatabase : RoomDatabase(){

    abstract fun favoriteDao(): FavoriteDao

    companion object{

        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getDatabase(context: Context) : NewsDatabase {

            INSTANCE?.let{
                return it
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news_database"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
