package core.domain.main

import core.entities.Article
import core.entities.Source
import core.env.Env
import naoko.Naoko
import naoko.entities.enum.Country
import naoko.entities.json.articles.NaokoArticles
import naoko.exception.NaokoException
import naoko.exception.NaokoExceptionStatus

internal class MainDomain : MainDomainInterface {

    private val naoko = Naoko.build(Env.API_KEY.value, Country.JP)

    override suspend fun getArticles(country: String): List<Article> {
        return try{
            val naokoArticles = naoko.getTopHeadlines(country = Country.serializer(country))
            convertToArticle(naokoArticles)
        }catch (e: NaokoException){
            when(e.status){
                NaokoExceptionStatus.RESPONSE_401 -> listOf(Article(title = "API_KEYを間違えています"))
                NaokoExceptionStatus.RESPONSE_429 -> listOf(Article(title = "API_KEYの制限が来ました"))
                else -> listOf(Article(title = e.message))
            }
        }
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
