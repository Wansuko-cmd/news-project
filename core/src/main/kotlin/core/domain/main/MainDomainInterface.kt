package core.domain.main

import core.entities.Article
import org.koin.core.component.KoinComponent

internal interface MainDomainInterface : KoinComponent {

    suspend fun getArticles(): List<Article>
}
