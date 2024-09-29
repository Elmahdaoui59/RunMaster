package com.running.runmaster

import android.app.Application
import com.running.auth.data.di.authDataModule
import com.running.auth.presentation.di.authViewModelModule
import com.running.core.data.di.coreDataModule
import com.running.run.location.di.locationModule
import com.running.run.presentation.di.runPresentationModule
import com.running.runmaster.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RunMasterApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RunMasterApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule
            )
        }
    }
}