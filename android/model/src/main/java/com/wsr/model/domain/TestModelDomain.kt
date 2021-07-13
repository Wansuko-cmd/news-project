package com.wsr.model.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wsr.model.db.entities.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class TestModelDomain : ModelDomainInterface{

    override val favorites: LiveData<List<Favorite>> = MutableLiveData(testFavorites)

    override suspend fun insertFavorite(favorite: Favorite): Unit = withContext(Dispatchers.IO){
        testFavorites.add(favorite)
    }

    override suspend fun deleteFavorite(id: Int): Unit = withContext(Dispatchers.IO){
        testFavorites.removeIf { it.id == id }
    }

    companion object{
        val testFavorites = mutableListOf(
            Favorite(
                id = 1,
                title="幻となったセブンの関西私鉄攻略計画 店から線にならず - 日本経済新聞",
                url="https://www.nikkei.com/article/DGXZQOGH30BSI0Q1A630C2000000/",
                createdAt = LocalDateTime.now()
            )
        )
    }
}
