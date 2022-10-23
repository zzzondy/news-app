package com.newsappcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.newsappcompose.domain.models.News
import com.newsappcompose.domain.usecase.GetNewsByPageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getNewsByPageUseCase: GetNewsByPageUseCase) : ViewModel() {

    val news = getNewsByPageUseCase().cachedIn(viewModelScope)

}