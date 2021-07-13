package com.wsr.model.domain

import android.app.Application
import androidx.lifecycle.LiveData
import com.wsr.model.db.database.NewsDatabase
import com.wsr.model.db.entities.Favorite
import kotlinx.coroutines.MainScope

class ModelDomain(application: Application) : ModelDomainInterface {

    private val favoriteDao = NewsDatabase.getDatabase(application, MainScope()).favoriteDao()
    override val favorites: LiveData<List<Favorite>> = favoriteDao.getAll()

    override suspend fun insertFavorite(favorite: Favorite) {
        favoriteDao.insert(favorite)
    }

    override suspend fun deleteFavorite(id: Int) {
        favoriteDao.delete(id)
    }
}
