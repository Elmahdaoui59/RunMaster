package com.running.runmaster

import android.app.Application
import com.running.auth.data.di.authDataModule
import com.running.auth.presentation.di.authViewModelModule
import com.running.core.data.di.coreDataModule
import com.running.core.database.di.databaseModule
import com.running.run.data.di.runDataModule
import com.running.run.location.di.locationModule
import com.running.run.network.di.networkModule
import com.running.run.presentation.di.runPresentationModule
import com.running.runmaster.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
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
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}