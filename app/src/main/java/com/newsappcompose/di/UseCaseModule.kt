package com.newsappcompose.di

import com.newsappcompose.data.repository.NewsRepositoryImpl
import com.newsappcompose.data.repository.datasource.NewsDataSource
import com.newsappcompose.data.repository.datasource.NewsDataSourceImpl
import com.newsappcompose.domain.repository.NewsRepository
import com.newsappcompose.domain.usecase.GetNewsByPageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsDataSource: NewsDataSourceImpl): NewsRepository = NewsRepositoryImpl(newsDataSource)

    @Provides
    @Singleton
    fun provideGetNewsByPageUseCase(newsRepository: NewsRepository): GetNewsByPageUseCase = GetNewsByPageUseCase(newsRepository)
}