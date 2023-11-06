package com.desafiolatam.pruebam5.di

import android.content.Context
import androidx.room.Room
import com.desafiolatam.pruebam5.data.TaskDao
import com.desafiolatam.pruebam5.data.TaskDataBase
import com.desafiolatam.pruebam5.view.ui.TaskAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object TaskModule {
    @Provides
    @Singleton
    fun provideTaskDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TaskDataBase::class.java, "task_db")

            .fallbackToDestructiveMigration()
            .createFromAsset("task.db")
            .build()

    @Provides
    fun provideTaskDao(db: TaskDataBase): TaskDao = db.taskDao()

    @Provides
    fun provideAdapter(): TaskAdapter = TaskAdapter()
}