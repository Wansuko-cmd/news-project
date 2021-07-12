package com.wsr.model.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wsr.model.db.converters.LocalDateTimeConverter
import com.wsr.model.db.dao.FavoriteDao
import com.wsr.model.db.entities.Favorite
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Favorite::class], version = 1)
@TypeConverters(LocalDateTimeConverter::class)
abstract class NewsDatabase : RoomDatabase(){

    abstract fun favoriteDao(): FavoriteDao

    private class NewsDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){

    }

    companion object{

        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : NewsDatabase {

            INSTANCE?.let{
                return it
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news_database"
                )
                    .addCallback(NewsDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
