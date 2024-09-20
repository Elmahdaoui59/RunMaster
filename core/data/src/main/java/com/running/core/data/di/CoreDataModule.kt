package com.running.core.data.di

import com.running.core.data.auth.EncryptedSessionStorage
import com.running.core.data.networking.HttpClientFactory
import com.running.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val coreDataModule = module {
    single {
       HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}