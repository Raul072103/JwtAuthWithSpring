package com.raul.jwtauth.service

import com.raul.jwtauth.model.User
import com.raul.jwtauth.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User? {
        val found = userRepository.findByUUID(user.id)

        return if (found == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findByUUID(uuid: UUID): User? = userRepository.findByUUID(uuid)

    fun findAll(): Set<User> = userRepository.findAll()

    fun deleteByUUID(uuid: UUID): Boolean = userRepository.deleteByUUID(uuid)
}