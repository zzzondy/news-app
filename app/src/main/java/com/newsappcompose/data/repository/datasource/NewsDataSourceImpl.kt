package com.newsappcompose.data.repository.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.newsappcompose.domain.models.News
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private val newsSource: NewsSource) : NewsDataSource {
    override fun getNewsByPage(): Flow<PagingData<News>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { newsSource }
        ).flow
    }
}