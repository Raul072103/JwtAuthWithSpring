package com.raul.jwtauth.repository

import com.raul.jwtauth.model.Article
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Repository with purpose of retrieving articles.
 *
 * It mimics the functionality of an in-memory database without the added complexity.
 */
@Repository
class ArticleRepository {

    private val articles = listOf(
        Article(id = UUID.randomUUID(), title = "Article 1", content = "Content 1"),
        Article(id = UUID.randomUUID(), title = "Article 2", content = "Content 2"))

    fun findAll(): List<Article> = articles
}