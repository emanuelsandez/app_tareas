package com.desafiolatam.pruebam5.repository

import com.desafiolatam.pruebam5.data.TaskDao
import com.desafiolatam.pruebam5.data.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImp@Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override suspend fun getTasks(): Flow<List<TaskEntity>> = taskDao.getTasks()

    override suspend fun addTask(task: TaskEntity) = taskDao.addTask(task)

    override suspend fun deleteTask(task: TaskEntity) = taskDao.deleteTask(task.id)

    override suspend fun isTaskCompleted(task: TaskEntity, isCompleted: Boolean) =
        taskDao.taskCompleted(isCompleted, task.id)
}