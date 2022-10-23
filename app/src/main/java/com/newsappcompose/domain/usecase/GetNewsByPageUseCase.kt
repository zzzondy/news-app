package com.newsappcompose.domain.usecase

import com.newsappcompose.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsByPageUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke() = newsRepository.getNewsByPage()
}