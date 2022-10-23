package com.newsappcompose.di

import com.newsappcompose.data.api.repository.NewsApiRepository
import com.newsappcompose.data.repository.datasource.NewsDataSource
import com.newsappcompose.data.repository.datasource.NewsDataSourceImpl
import com.newsappcompose.data.repository.datasource.NewsSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class PagingModule {

    @Provides
    @Singleton
    fun provideNewsSource(newsApiRepository: NewsApiRepository): NewsSource = NewsSource(newsApiRepository)

    @Provides
    @Singleton
    fun provideNewsDataSource(newsSource: NewsSource): NewsDataSourceImpl = NewsDataSourceImpl(newsSource)

}