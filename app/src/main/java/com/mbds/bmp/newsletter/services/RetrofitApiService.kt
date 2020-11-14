package com.mbds.bmp.newsletter.services

import com.mbds.bmp.newsletter.model.NewsApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("everything?sortBy=publishedAt&language=en")
    fun list(@Query("q") category: String, @Query("page") page: Int): Call<NewsApiResponse>
}