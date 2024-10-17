package com.running.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.running.core.database.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {
    @Upsert
    suspend fun upsertRun(run: RunEntity)

    @Upsert
    suspend fun upsertRuns(runs: List<RunEntity>)

    @Query("select * from runentity order by dateTimeUtc desc")
    fun getRuns(): Flow<List<RunEntity>>

    @Query("delete from runentity where id=:id")
    suspend fun deleteRun(id: String)

    @Query("delete from runentity")
    suspend fun deleteAllRuns()
}