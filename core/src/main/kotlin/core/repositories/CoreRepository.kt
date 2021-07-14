package core.repositories

import core.di.CoreKoinComponent
import core.di.koinModule
import core.domain.main.MainDomainInterface
import core.entities.Article
import org.koin.core.component.inject

class CoreRepository : CoreKoinComponent {

    init {
        koinModule()
    }

    private val mainDomain by inject<MainDomainInterface>()

    suspend fun getArticle(country: String = "JP"): List<Article>{
        return mainDomain.getArticles(country)
    }
}
