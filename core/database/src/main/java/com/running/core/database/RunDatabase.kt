package com.running.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.running.core.database.dao.RunDao
import com.running.core.database.dao.RunPendingSyncDao
import com.running.core.database.entity.DeletedRunSyncEntity
import com.running.core.database.entity.RunEntity
import com.running.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}