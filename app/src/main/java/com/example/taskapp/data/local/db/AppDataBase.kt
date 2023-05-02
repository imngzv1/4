package com.example.taskapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskapp.model.Task

@Database(entities = [Task::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}