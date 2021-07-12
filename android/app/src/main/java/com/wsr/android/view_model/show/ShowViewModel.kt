package com.wsr.android.view_model.show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.db.entities.Favorite
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import kotlinx.coroutines.launch

class ShowViewModel : ViewModel(){

    private val favoriteRepository = FavoriteRepository()

    fun createFavorite(favorite: Favorite) = viewModelScope.launch{
        favoriteRepository.createFavorite(favorite)
    }
}
