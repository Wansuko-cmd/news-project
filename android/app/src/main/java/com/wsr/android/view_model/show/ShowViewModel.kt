package com.wsr.android.view_model.show

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.db.entities.Favorite
import com.wsr.model.repositories.FavoriteRepository
import kotlinx.coroutines.launch

class ShowViewModel(application: Application) : AndroidViewModel(application){

    private val favoriteRepository = FavoriteRepository(application)

    fun insertFavorite(favorite: Favorite) = viewModelScope.launch{
        favoriteRepository.insertFavorite(favorite)
    }
}
