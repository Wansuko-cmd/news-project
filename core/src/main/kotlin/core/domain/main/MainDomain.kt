package core.domain.main

import core.entities.Article
import core.entities.Source
import core.env.Env
import naoko.Naoko
import naoko.entities.enum.Country
import naoko.entities.json.articles.NaokoArticles

internal class MainDomain : MainDomainInterface {

    private val naoko = Naoko.build(Env.API_KEY.value, Country.JP)

    override suspend fun getArticles(): List<Article> {
        val naokoArticles = naoko.getTopHeadlines()
        return convertToArticle(naokoArticles)
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
