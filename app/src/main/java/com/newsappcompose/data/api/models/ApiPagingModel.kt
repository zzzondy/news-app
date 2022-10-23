package com.newsappcompose.data.api.models

@kotlinx.serialization.Serializable
data class ApiPagingModel(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val total: Int,
)
