package com.newsappcompose.data.repository.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.newsappcompose.data.api.repository.NewsApiRepository
import com.newsappcompose.data.util.toNews
import com.newsappcompose.domain.models.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsSource @Inject constructor(private val newsApiRepository: NewsApiRepository) : PagingSource<Int, News>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        return try {
            withContext(Dispatchers.IO) {
                val nextPage = (params.key ?: 1)
                val newsListResponse =
                    newsApiRepository.getNewsByPage(nextPage, 5, "en").map { it.toNews() }

                Log.d("MAIN", nextPage.toString())

                return@withContext LoadResult.Page(
                    data = newsListResponse,
                    prevKey = if (nextPage == 1) null else nextPage - 5,
                    nextKey = nextPage + 5
                )
            }
        } catch (e: Exception) {
            Log.d("MAIN", e.toString())
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition
    }
}