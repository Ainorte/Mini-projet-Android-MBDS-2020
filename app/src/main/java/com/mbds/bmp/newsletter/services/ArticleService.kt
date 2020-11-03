package com.mbds.bmp.newsletter.services

import com.mbds.bmp.newsletter.data.Article

interface ArticleService {
    fun getArticles(): List<Article>
}