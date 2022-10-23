package com.newsappcompose.data.api.repository

import com.newsappcompose.data.api.NewsApi
import com.newsappcompose.data.api.models.ApiNewsModel
import javax.inject.Inject

class NewsApiRepositoryImpl(private val newsApi: NewsApi) : NewsApiRepository {
    override suspend fun getNewsByPage(
        page: Int,
        limit: Int,
        languages: String
    ): List<ApiNewsModel> = newsApi.getNewsByPage(page, limit, languages).data
}