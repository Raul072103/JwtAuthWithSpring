package com.raul.jwtauth.controller.auth

data class AuthenticationRequest(
    val email: String,
    val password: String,
)
