package com.wsr.model.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wsr.model.db.entities.Favorite

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_table")
    fun getAll(): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)

    @Query("DELETE FROM favorite_table WHERE id=:id")
    suspend fun delete(id: Int)
}
