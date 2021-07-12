package com.wsr.model.repositories

import com.wsr.model.db.entities.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class FavoriteRepository {

    suspend fun getAllFavorites(): List<Favorite> = withContext(Dispatchers.IO){
        return@withContext favorites
    }

    suspend fun createFavorite(value: Favorite) = withContext(Dispatchers.IO){
        favorites.add(value)
    }

    suspend fun deleteFavorite(id: Int) = withContext(Dispatchers.IO){
        favorites.removeIf { it.id == id }
    }

    companion object{
        val favorites = mutableListOf(
            Favorite(
                id = 1,
                title="幻となったセブンの関西私鉄攻略計画 店から線にならず - 日本経済新聞",
                url="https://www.nikkei.com/article/DGXZQOGH30BSI0Q1A630C2000000/",
                createdAt = LocalDateTime.now()
            )
        )
    }
}
