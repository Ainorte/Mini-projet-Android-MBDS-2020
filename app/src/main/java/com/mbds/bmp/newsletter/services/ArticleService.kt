package com.mbds.bmp.newsletter.services

import com.mbds.bmp.newsletter.model.NewsApiResponse

interface ArticleService {
    fun getArticles(category: String, page: Int): retrofit2.Response<NewsApiResponse>
}