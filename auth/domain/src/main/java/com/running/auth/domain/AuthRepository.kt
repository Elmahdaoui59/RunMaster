package com.running.auth.domain

import com.running.core.domain.util.DataError
import com.running.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}