package com.raul.jwtauth.configuration

import io.jsonwebtoken.Jwts
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Gets the configurations from the [application.yaml] file.
 */
@ConfigurationProperties("jwt")
data class JwtProperties(
    val key: String = Jwts.SIG.HS256.key().toString(),
    val accessTokenExpiration: Long,
    val refreshTokenExpiration: Long,
)