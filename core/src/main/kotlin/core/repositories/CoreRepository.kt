package core.repositories

import core.di.koinModule
import core.domain.main.MainDomainInterface
import core.entities.Article
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CoreRepository : KoinComponent {

    init {
        koinModule()
    }

    private val mainDomain by inject<MainDomainInterface>()

    suspend fun getArticle(): List<Article>{
        return mainDomain.getArticles()
    }
}
