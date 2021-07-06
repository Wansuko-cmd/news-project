package core.domain.main

import core.entities.Article
import core.entities.Source
import kotlinx.coroutines.runBlocking
import naoko.entities.json.articles.NaokoArticles

internal class MainDomain : MainDomainInterface {

    override suspend fun getArticles(): List<Article> {

        return mutableListOf()
    }

    private fun convertToArticle(naokoArticle: NaokoArticles): List<Article>{

        val result = mutableListOf<Article>()

        naokoArticle.articles?.let{
            it.forEach { article ->
                result.add(
                    Article(
                        source = Source(article.source?.id, article.source?.name),
                        author = article.author,
                        title = article.title,
                        description = article.description,
                        url = article.url,
                        urlToImage = article.urlToImage,
                        publishedAt = article.publishedAt,
                        content = article.content
                    )
                )
            }
        }

        return result
    }
}
