package com.wsr.model.repositories

import androidx.lifecycle.LiveData
import com.wsr.model.db.entities.Favorite
import com.wsr.model.di.ModelKoinComponent
import com.wsr.model.di.koinModule
import com.wsr.model.domain.ModelDomainInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDateTime

class FavoriteRepository: ModelKoinComponent{

    init {
        koinModule()
    }

    private val modelDomain by inject<ModelDomainInterface>()

    fun getAllFavorites(): LiveData<List<Favorite>> = modelDomain.favorites

    suspend fun createFavorite(favorite: Favorite): Unit = modelDomain.insertFavorite(favorite)

    suspend fun deleteFavorite(id: Int): Unit = modelDomain.deleteFavorite(id)

}
