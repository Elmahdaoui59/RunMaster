package com.running.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.running.core.database.entity.DeletedRunSyncEntity
import com.running.core.database.entity.RunEntity
import com.running.core.database.entity.RunPendingSyncEntity

@Dao
interface RunPendingSyncDao {

    // Created runs

    @Query("select * from runpendingsyncentity where userId=:userId")
    suspend fun getAllRunPendingSyncEntities(userId: String): List<RunPendingSyncEntity>

    @Query("select * from runpendingsyncentity where runId=:runId")
    suspend fun getRunPendingSyncEntity(runId: String): RunPendingSyncEntity?

    @Upsert
    suspend fun upsertRunPendingSyncEntity(entity: RunPendingSyncEntity)

    @Query("delete from runpendingsyncentity where runId=:runId")
    suspend fun deleteRunPendingSyncEntity(runId: String)

    // Deleted runs
    @Query("select * from deletedrunsyncentity where userId=:userId")
    suspend fun getAllDeletedRunSyncEntities(userId: String): List<DeletedRunSyncEntity>

    @Upsert
    suspend fun upsertDeletedRunSyncEntity(entity: DeletedRunSyncEntity)

    @Query("delete from deletedrunsyncentity where runId=:runId")
    suspend fun deleteDeletedRunSyncEntity(runId: String)
}