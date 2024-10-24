package com.running.run.data.di

import com.running.run.data.CreateRunWorker
import com.running.run.data.DeleteRunWorker
import com.running.run.data.FetchRunWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunWorker)
    workerOf(::DeleteRunWorker)
}