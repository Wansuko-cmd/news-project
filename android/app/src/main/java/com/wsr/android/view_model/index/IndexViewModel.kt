package com.wsr.android.view_model.index

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import core.repositories.CoreRepository
import kotlinx.coroutines.launch

class IndexViewModel : ViewModel() {

    private val coreRepository = CoreRepository()
    private val favoriteRepository = FavoriteRepository()

    val articles: MutableLiveData<List<Article>> = MutableLiveData()

    init {
        viewModelScope.launch {
            articles.postValue(coreRepository.getArticle())
        }
    }

    fun createFavorite(article: Article) = viewModelScope.launch {
        favoriteRepository.createFavorite(article)
    }
}
