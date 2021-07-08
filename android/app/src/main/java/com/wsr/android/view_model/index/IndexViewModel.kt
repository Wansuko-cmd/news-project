package com.wsr.android.view_model.index

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.entities.Article
import core.repositories.CoreRepository
import kotlinx.coroutines.launch

class IndexViewModel : ViewModel() {

    private val coreRepository = CoreRepository()

    lateinit var articles: LiveData<List<Article>>

    init {
        viewModelScope.launch {
            articles = MutableLiveData(coreRepository.getArticle())
        }
    }
}