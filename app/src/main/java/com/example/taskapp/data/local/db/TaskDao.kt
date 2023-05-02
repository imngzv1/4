package com.example.taskapp.data.local.db

import androidx.room.*
import com.example.taskapp.model.Task


@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task?)

    @Query("SELECT * FROM Task")
    fun getAllTask(): List<Task>?


    @Query("SELECT * FROM Task ORDER BY id DESC")
    fun getAllTaskByDate(): List<Task?>?

    @Delete
    fun delete(task: Task?)

    @Update
    fun update(task: Task?)
}