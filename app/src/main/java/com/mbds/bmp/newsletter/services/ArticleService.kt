package com.mbds.bmp.newsletter.services

import com.mbds.bmp.newsletter.model.NewsApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("everything?sortBy=publishedAt&language=en")
    fun list(@Query("q") category: String, @Query("page") page: Int): Call<NewsApiResponse>
}