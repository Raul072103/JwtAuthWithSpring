package com.raul.jwtauth.controller.user

data class UserRequest(
    val email: String,
    val password: String,
)