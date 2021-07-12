package com.wsr.model.domain

import com.wsr.model.db.entities.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class TestModelDomain : ModelDomainInterface{
    override suspend fun getAllFavorites(): List<Favorite> = withContext(Dispatchers.IO){
        return@withContext favorites
    }

    override suspend fun insertFavorite(favorite: Favorite): Unit = withContext(Dispatchers.IO){
        favorites.add(favorite)
    }

    override suspend fun deleteFavorite(id: Int): Unit = withContext(Dispatchers.IO){
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
