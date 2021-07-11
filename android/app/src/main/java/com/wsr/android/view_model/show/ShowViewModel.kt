package com.wsr.android.view_model.show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import kotlinx.coroutines.launch

class ShowViewModel : ViewModel(){

    private val favoriteRepository = FavoriteRepository()

    fun createFavorite(article: Article) = viewModelScope.launch{
        favoriteRepository.createFavorite(article)
    }
}
