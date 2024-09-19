package com.running.core.data.di

import com.running.core.data.networking.HttpClientFactory
import org.koin.dsl.module


val coreDataModule = module {
    single {
       HttpClientFactory().build()
    }
}