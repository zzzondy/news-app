package com.newsappcompose.data.repository.datasource

import androidx.paging.PagingData
import com.newsappcompose.domain.models.News
import kotlinx.coroutines.flow.Flow

interface NewsDataSource {
    fun getNewsByPage(): Flow<PagingData<News>>
}