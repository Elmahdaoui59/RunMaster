package com.running.run.presentation.di

import com.running.run.domain.RunningTracker
import com.running.run.presentation.active_run.ActiveRunViewModel
import com.running.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}