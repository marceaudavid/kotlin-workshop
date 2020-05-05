package com.example.kotlinworkshop

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<ToDo>

    @Query("SELECT * FROM todo WHERE id  LIKE :id")
    fun findById(id: Int): ToDo

    @Query("SELECT * FROM todo WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): ToDo

    @Insert
    fun insert(vararg todo: ToDo)

    @Delete
    fun delete(todo: ToDo)
}