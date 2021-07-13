package com.wsr.model.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.wsr.model.db.entities.Favorite
import com.wsr.model.di.ModelKoinComponent
import com.wsr.model.di.koinModule
import com.wsr.model.domain.ModelDomainInterface
import org.koin.core.component.inject

class FavoriteRepository(application: Application): ModelKoinComponent{

    init {
        koinModule(application)
    }

    private val modelDomain by inject<ModelDomainInterface>()

    fun getAllFavorites(): LiveData<List<Favorite>> = modelDomain.favorites

    suspend fun insertFavorite(favorite: Favorite): Unit = modelDomain.insertFavorite(favorite)

    suspend fun deleteFavorite(id: Int): Unit = modelDomain.deleteFavorite(id)

}
