package core.repositories

import core.domain.MainDomain
import core.entities.Article

class CoreRepository {

    private val mainDomain = MainDomain()

    fun getArticle(): List<Article>{
        return mainDomain.getArticles()
    }
}
