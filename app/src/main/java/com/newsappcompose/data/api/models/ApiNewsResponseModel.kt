package com.newsappcompose.data.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiNewsResponseModel(
    val pagination: ApiPagingModel,
    val data: List<ApiNewsModel>,
)
