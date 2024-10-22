package com.running.run.network.di

import com.running.core.domain.run.RemoteRunDataSource
import com.running.run.network.KtorRemoteDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteDataSource).bind<RemoteRunDataSource>()
}