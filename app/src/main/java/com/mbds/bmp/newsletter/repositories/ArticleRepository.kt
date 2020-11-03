package com.mbds.bmp.newsletter.repositories

import com.mbds.bmp.newsletter.services.ArticleOnlineService
import com.mbds.bmp.newsletter.services.ArticleService

class ArticleRepository {
    companion object {
        private val instance = ArticleOnlineService()
        fun getInstance(): ArticleService {
            return instance
        }
    }
}
