package com.newsappcompose.data.api

import com.newsappcompose.BuildConfig
import com.newsappcompose.data.api.models.ApiNewsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("news?access_key=${BuildConfig.API_KEY}")
    suspend fun getNewsByPage(
        @Query("offset") page: Int,
        @Query("limit") limit: Int,
        @Query("languages") languages: String
    ): ApiNewsResponseModel
}