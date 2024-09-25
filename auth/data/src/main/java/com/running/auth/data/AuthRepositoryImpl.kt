package com.running.auth.data

import com.running.auth.domain.AuthRepository
import com.running.core.data.networking.post
import com.running.core.domain.AuthInfo
import com.running.core.domain.SessionStorage
import com.running.core.domain.util.DataError
import com.running.core.domain.util.EmptyResult
import com.running.core.domain.util.Result
import com.running.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse >(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }
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