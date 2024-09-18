package com.running.auth.data.di

import com.running.auth.data.EmailPatternValidator
import com.running.auth.domain.PatternValidator
import com.running.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}