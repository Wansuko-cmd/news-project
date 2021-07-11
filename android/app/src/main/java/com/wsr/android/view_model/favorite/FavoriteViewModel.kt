package com.wsr.android.view_model.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel(){

    private val favoriteRepository = FavoriteRepository()

    lateinit var articles: LiveData<List<Article>>

    init {
        viewModelScope.launch {
            articles = MutableLiveData(favoriteRepository.getAllFavorites())
        }
    }
}
