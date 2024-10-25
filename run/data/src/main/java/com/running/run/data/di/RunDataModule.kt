package com.running.run.data.di

import com.running.core.domain.run.SyncRunScheduler
import com.running.run.data.CreateRunWorker
import com.running.run.data.DeleteRunWorker
import com.running.run.data.FetchRunWorker
import com.running.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}