package com.mbds.bmp.newsletter.services

import com.mbds.bmp.newsletter.model.ArticleNewsApiResponse
import com.mbds.bmp.newsletter.model.SourceNewsApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("everything?sortBy=publishedAt")
    fun list(
        @Query("q") category: String = "",
        @Query("page") page: Int,
        @Query("language") language: String = "en"
    ): Call<ArticleNewsApiResponse>

    @GET("sources")
    fun editors(): Call<SourceNewsApiResponse>
}