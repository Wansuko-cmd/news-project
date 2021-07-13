package com.wsr.android.view_model.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.db.entities.Favorite
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel(){

    private val favoriteRepository = FavoriteRepository()

    val favorites: LiveData<List<Favorite>> = favoriteRepository.getAllFavorites()

    fun deleteFavorite(id: Int) = viewModelScope.launch{
        favoriteRepository.deleteFavorite(id)
    }
}
