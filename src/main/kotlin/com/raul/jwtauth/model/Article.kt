package com.raul.jwtauth.model

import java.util.*

/**
 * Model representing an Article.
 */
data class Article(
    val id: UUID,
    val title: String,
    val content: String,
)