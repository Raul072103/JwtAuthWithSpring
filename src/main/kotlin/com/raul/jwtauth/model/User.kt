package com.raul.jwtauth.model

import java.util.UUID

/**
 * Model for representing a User.
 */
data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val role: Role
)

/**
 * Possible roles of an User.
 */
enum class Role {
    USER, ADMIN
}