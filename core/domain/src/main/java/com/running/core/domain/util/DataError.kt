package com.running.core.domain.util

sealed   interface DataError: Error {
    enum class Network: DataError {
        REQUEST_TIMEOUT,
        UNAUTHORIZED,
        CONFLICT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERIALIZATION,
        UNKNOWN,
        SERVER_ERROR
    }
    enum class Local: DataError {
        DISK_FULL
    }
}