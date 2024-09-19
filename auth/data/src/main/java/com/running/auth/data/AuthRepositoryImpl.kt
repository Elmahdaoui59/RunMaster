package com.running.auth.data

import com.running.auth.domain.AuthRepository
import com.running.core.data.networking.post
import com.running.core.domain.util.DataError
import com.running.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit> (
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}