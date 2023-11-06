package com.desafiolatam.pruebam5.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 2)
abstract class TaskDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}