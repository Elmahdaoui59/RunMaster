package com.running.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}