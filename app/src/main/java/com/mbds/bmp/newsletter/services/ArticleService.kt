package com.mbds.bmp.newsletter.services

import com.mbds.bmp.newsletter.model.ArticleNewsApiResponse

interface ArticleService {
    fun getArticles(
        category: String,
        country: String,
        page: Int
    ): retrofit2.Response<ArticleNewsApiResponse>
}