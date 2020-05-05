package com.example.kotlinworkshop

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDo::class], version = 1)
public abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

    companion object {
        private var db: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase? {
            if (db == null) {
                synchronized(ToDoDatabase::class) {
                    db = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java, "todo.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return db
        }

        fun destroyInstance() {
            db = null
        }
    }
}