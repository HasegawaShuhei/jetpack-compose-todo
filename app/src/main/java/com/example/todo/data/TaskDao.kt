package com.example.todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Upsert()
    suspend fun upsert(task: Task)

    @Query("SELECT * FROM tasks WHERE status = :status")
    fun getTasksByStatus(status: Status): Flow<List<Task>>

    @Delete
    suspend fun delete(task: Task)
}