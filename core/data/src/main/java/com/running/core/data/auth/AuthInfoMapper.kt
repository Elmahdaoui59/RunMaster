package com.running.core.data.auth

import com.running.core.domain.AuthInfo


fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable {
    return AuthInfoSerializable(
        accessToken, refreshToken, userId
    )
}

fun AuthInfoSerializable.toAuthInfo(): AuthInfo {
    return AuthInfo(
        accessToken, refreshToken, userId
    )
}