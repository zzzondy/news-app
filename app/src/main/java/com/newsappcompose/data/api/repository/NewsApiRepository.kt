package com.newsappcompose.data.api.repository

import com.newsappcompose.data.api.models.ApiNewsModel

interface NewsApiRepository {
    suspend fun getNewsByPage(page: Int, limit: Int, languages: String): List<ApiNewsModel>
}