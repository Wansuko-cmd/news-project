package com.wsr.android.view_model.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel(){

    private val favoriteRepository = FavoriteRepository()

    val articles: MutableLiveData<List<Article>> = MutableLiveData()

    init {
        viewModelScope.launch {
            articles.postValue(favoriteRepository.getAllFavorites())
        }
    }
}
