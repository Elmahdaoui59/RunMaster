package com.running.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.running.core.domain.run.RunRepository
import com.running.core.domain.util.DataError
import com.running.core.domain.util.Result

class FetchRunWorker(
    context: Context,
    params: WorkerParameters,
    private val runRepository: RunRepository
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }
        return when(val result = runRepository.fetchRuns()) {
            is com.running.core.domain.util.Result.Error -> {
                result.error.toWorkerResult()
            }
            is com.running.core.domain.util.Result.Success -> Result.success()
        }
    }
}