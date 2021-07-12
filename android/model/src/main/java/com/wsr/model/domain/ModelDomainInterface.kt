package com.wsr.model.domain

import com.wsr.model.db.entities.Favorite

interface ModelDomainInterface {

    suspend fun getAllFavorites(): List<Favorite>

    suspend fun insertFavorite(favorite: Favorite)

    suspend fun deleteFavorite(id: Int)
}
