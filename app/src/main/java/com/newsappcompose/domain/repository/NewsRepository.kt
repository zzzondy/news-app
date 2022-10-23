package com.newsappcompose.domain.repository

import androidx.paging.PagingData
import com.newsappcompose.domain.models.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNewsByPage(): Flow<PagingData<News>>
}