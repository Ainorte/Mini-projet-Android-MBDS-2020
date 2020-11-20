package com.mbds.bmp.newsletter.repositories

import com.mbds.bmp.newsletter.model.Article
import com.mbds.bmp.newsletter.model.Category
import com.mbds.bmp.newsletter.model.Country
import com.mbds.bmp.newsletter.model.Editor
import com.mbds.bmp.newsletter.services.ArticleOnlineService
import com.mbds.bmp.newsletter.services.ArticleService
import okhttp3.Interceptor
import okhttp3.Response


class ArticleRepository {
    private val service: ArticleService
    private var page = 1
    private var maxpage = -1

    init {
        service = ArticleOnlineService()
    }

    class AuthenticationInterceptor: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            val headers = request
                .headers
                .newBuilder()
                .add("Authorization", "Bearer 5a7700db7c2f43e3bbc789c5a2a655c8")
                .build()
            request = request
                .newBuilder()
                .headers(headers)
                .build()
            return chain.proceed(request)
        }

    }

    fun list(category: Category?, country: Country?, editor: Editor?): List<Article>? {
        if (maxpage < 0 || page < maxpage) {
            TODO("A faire")
            val response = service.getArticles("", "", 0)
            if (response.isSuccessful) {
                maxpage = response.body()?.totalResults?.div(20) ?: maxpage
                page++
                return response.body()?.articles?.toList() ?: emptyList()
            }
            return null
        }
        return listOf()
    }

    fun listFav(): List<Article>? {
        TODO("A faire")
    }
}

