package com.wsr.model.domain

import androidx.lifecycle.LiveData
import com.wsr.model.db.entities.Favorite

interface ModelDomainInterface {

    val favorites: LiveData<List<Favorite>>

    suspend fun insertFavorite(favorite: Favorite)

    suspend fun deleteFavorite(id: Int)
}
