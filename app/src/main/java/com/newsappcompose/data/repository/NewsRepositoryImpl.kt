package com.newsappcompose.data.repository

import androidx.paging.PagingData
import com.newsappcompose.data.repository.datasource.NewsDataSource
import com.newsappcompose.domain.models.News
import com.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl(private val newsDataSource: NewsDataSource) : NewsRepository {
    override fun getNewsByPage(): Flow<PagingData<News>> = newsDataSource.getNewsByPage()
}