package com.mbds.bmp.newsletter.services

import android.os.Parcelable
import com.mbds.bmp.newsletter.model.Article

interface ArticleService : Parcelable {
    fun getArticles(page: Int): List<Article>?

    fun getTitleId(): Int

    fun getPageNumber(): Int
}