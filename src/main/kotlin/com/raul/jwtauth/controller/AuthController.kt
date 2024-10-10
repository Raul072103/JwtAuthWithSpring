package com.raul.jwtauth.controller

import com.raul.jwtauth.controller.auth.AuthenticationRequest
import com.raul.jwtauth.controller.auth.AuthenticationResponse
import com.raul.jwtauth.controller.token.RefreshTokenRequest
import com.raul.jwtauth.controller.token.TokenResponse
import com.raul.jwtauth.service.AuthenticationService
import org.apache.el.parser.Token
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

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

    @PostMapping("/refresh")
    fun refreshAccessToken(
        @RequestBody request: RefreshTokenRequest
    ): TokenResponse =
        authenticationService.refreshAccessToken(request.token)
            ?.mapToTokenResponse()
            ?: throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid refresh token")

    private fun String.mapToTokenResponse(): TokenResponse =
        TokenResponse(token = this)
}