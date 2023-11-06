package com.desafiolatam.pruebam5.repository

import com.desafiolatam.pruebam5.data.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getTasks(): Flow<List<TaskEntity>>
    suspend fun addTask(task: TaskEntity)
    suspend fun deleteTask(task: TaskEntity)
    suspend fun isTaskCompleted(task: TaskEntity, isCompleted: Boolean)
}