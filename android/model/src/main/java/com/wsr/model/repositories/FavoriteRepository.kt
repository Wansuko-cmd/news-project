package com.wsr.model.repositories

import core.entities.Article
import core.entities.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteRepository {

    suspend fun getAllFavorites(): List<Article> = withContext(Dispatchers.IO){
        return@withContext favorites
    }

    suspend fun createFavorite(value: Article) = withContext(Dispatchers.IO){
        favorites.add(value)
    }

    companion object{
        val favorites = mutableListOf(
            Article(
                source = Source(
                    id=null,
                    name="Nikkei.com"
                ),
                author="日本経済新聞社",
                title="幻となったセブンの関西私鉄攻略計画 店から線にならず - 日本経済新聞",
                description="「もう、この話は……」6月22日午後、コンビニエンスストア業界3位のローソンが、阪急阪神百貨店などを傘下に持つエイチ・ツー・オーリテイリング（H2O）と提携するとの情報がコンビニ業界に広まったとき、最大手セブン―イレブン・ジャパンを抱えるセブン&アイ・ホールディングス（HD）の幹部に感想を聞くと、口ごもった。その2日後の24日、ローソンとH2Oは包括業務提携契約を結んだと発表した。H2Oグル",
                url="https://www.nikkei.com/article/DGXZQOGH30BSI0Q1A630C2000000/",
                urlToImage="https://article-image-ix.nikkei.com/https%3A%2F%2Fimgix-proxy.n8s.jp%2FDSXZQO0775952001072021000000-1.jpg?auto=format%2Ccompress&ch=Width%2CDPR&q=45&fit=crop&bg=FFFFFF&w=1200&h=630&fp_x=0.19&fp_y=0.41&fp_z=1&crop=focalpoint&ixlib=js-1.4.1&s=c81ccb564c1eae28f32de69afd9b17f9",
                publishedAt="2021-07-06T02:00:00Z",
                content=null
            )
        )
    }
}
