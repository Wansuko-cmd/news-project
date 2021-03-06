package com.wsr.android.view_model.index

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wsr.android.view.settings.checkCollectCountry
import com.wsr.model.db.entities.Favorite
import com.wsr.model.repositories.FavoriteRepository
import core.entities.Article
import core.repositories.CoreRepository
import kotlinx.coroutines.launch

class IndexViewModel(application: Application) : AndroidViewModel(application) {

    private val coreRepository = CoreRepository()
    private val favoriteRepository = FavoriteRepository(application)

    private val app = application

    val articles: MutableLiveData<List<Article>> = MutableLiveData()

    init {
        viewModelScope.launch {
            articles.postValue(coreRepository.getArticle(checkCollectCountry(application)))
        }
    }

    fun reloadArticles() = viewModelScope.launch{
        articles.postValue(coreRepository.getArticle(checkCollectCountry(app)))
    }

    fun insertFavorite(favorite: Favorite) = viewModelScope.launch {
        favoriteRepository.insertFavorite(favorite)
    }
}
