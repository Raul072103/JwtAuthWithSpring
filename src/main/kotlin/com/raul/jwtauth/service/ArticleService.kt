package com.raul.jwtauth.service

import com.raul.jwtauth.model.Article
import com.raul.jwtauth.repository.ArticleRepository
import org.springframework.stereotype.Service

/**
 * Service for retrieving the articles.
 */
@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {

    fun findAll(): List<Article> = articleRepository.findAll()
}