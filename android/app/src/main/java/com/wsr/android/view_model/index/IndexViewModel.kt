package com.wsr.android.view_model.index

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import core.repositories.CoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IndexViewModel : ViewModel() {

    private val coreRepository = CoreRepository()
    private val favoriteRepository = FavoriteRepository()

    lateinit var articles: LiveData<List<Article>>

    init {
        viewModelScope.launch {
            articles = MutableLiveData(coreRepository.getArticle())
        }
    }

    fun createFavorite(article: Article) = viewModelScope.launch {
        favoriteRepository.createFavorite(article)
    }
}
