package com.newsappcompose.data.util

import com.newsappcompose.data.api.models.ApiNewsModel
import com.newsappcompose.domain.models.News

fun ApiNewsModel.toNews(): News = News(
    author, title, description, url, source, image, category, language, country, publishedAt
)