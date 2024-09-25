package com.running.runmaster

import android.app.Application
import com.running.auth.data.di.authDataModule
import com.running.auth.presentation.di.authViewModelModule
import com.running.core.data.di.coreDataModule
import com.running.run.presentation.di.runModule
import com.running.runmaster.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RunMasterApp: Application() {
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
                runModule
            )
        }
    }
}