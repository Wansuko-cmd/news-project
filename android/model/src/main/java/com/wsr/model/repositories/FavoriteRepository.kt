package com.wsr.model.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.wsr.model.db.entities.Favorite
import com.wsr.model.di.ModelKoinComponent
import com.wsr.model.di.koinModule
import com.wsr.model.domain.ModelDomain
import com.wsr.model.domain.ModelDomainInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDateTime

class FavoriteRepository(application: Application): ModelKoinComponent{

//    init {
//        koinModule(application)
//    }

//    private val modelDomain by inject<ModelDomainInterface>()

    private val modelDomain = ModelDomain(application)

    fun getAllFavorites(): LiveData<List<Favorite>> = modelDomain.favorites

    suspend fun createFavorite(favorite: Favorite): Unit = modelDomain.insertFavorite(favorite)

    suspend fun deleteFavorite(id: Int): Unit = modelDomain.deleteFavorite(id)

}
