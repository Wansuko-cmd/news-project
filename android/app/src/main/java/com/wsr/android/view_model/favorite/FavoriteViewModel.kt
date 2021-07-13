package com.wsr.android.view_model.favorite

import android.app.Application
import androidx.lifecycle.*
import com.wsr.model.db.entities.Favorite
import com.wsr.model.repositories.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application){

    private val favoriteRepository = FavoriteRepository(application)

    val favorites: LiveData<List<Favorite>> = favoriteRepository.getAllFavorites()

    fun deleteFavorite(id: Int) = viewModelScope.launch{
        favoriteRepository.deleteFavorite(id)
    }
}
