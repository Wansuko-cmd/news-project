package core.domain

import core.entities.Article
import core.entities.Source
import kotlinx.coroutines.runBlocking
import naoko.entities.json.articles.NaokoArticles

internal class MainDomain {

    fun getArticles(): List<Article> = runBlocking {

        return@runBlocking mutableListOf(
            Article(
                source = Source(
                    id="google-news", name="Google News"
                ),
                author=null,
                title="「かっぱ寿司」運営会社を捜索 「はま寿司」の告訴受け - FNNプライムオンライン",
                description=null,
                url="https://news.google.com/__i/rss/rd/articles/CBMiK2h0dHBzOi8vd3d3LnlvdXR1YmUuY29tL3dhdGNoP3Y9VEQtMHpNSVNNS0XSAQA?oc=5",
                urlToImage=null,
                publishedAt="2021-07-06T02:04:36Z",
                content=null
            ),
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
            ),
            Article(
                source=Source(
                    id=null,
                    name="Livedoor.com"
                ),
                author="テレ朝news",
                title="割り込みに蛇行運転、最後には停止 悪質あおり運転男を逮捕 - ライブドアニュース - livedoor",
                description="福岡県で走行するトラックのドライブレコーダーの映像が、番組で紹介された。突然、1台の車が割り込んできた上に蛇行運転で道をふさぎ、最後には停止。5日、映像をもとに車を運転していた25歳男があおり運転容疑で再逮捕された",
                url="https://news.livedoor.com/article/detail/20483480/",
                urlToImage="https://image.news.livedoor.com/newsimage/stf/b/b/bb25a_1641_9f1e9b74_f816110a.jpg",
                publishedAt="2021-07-06T00:42:00Z",
                content=null
            )
        )
    }

    fun convertToArticle(naokoArticle: NaokoArticles): List<Article>{

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
