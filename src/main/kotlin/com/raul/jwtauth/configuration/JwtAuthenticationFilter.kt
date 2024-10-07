package com.raul.jwtauth.configuration

import com.raul.jwtauth.service.CustomUserDetailsService
import com.raul.jwtauth.service.TokenService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val userDetailsService: CustomUserDetailsService,
    private val tokenService: TokenService,
) : OncePerRequestFilter{
}