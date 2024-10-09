package com.raul.jwtauth.controller

import com.raul.jwtauth.controller.auth.AuthenticationRequest
import com.raul.jwtauth.controller.auth.AuthenticationResponse
import com.raul.jwtauth.service.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {

    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest
    ): AuthenticationResponse {
        println("TRIED TO auth: ${authRequest.email} + ${authRequest.password}")
        return authenticationService.authentication(authRequest)
    }
}