package com.usfuchsia.offlinenoteappcompose.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(toDo : ToDo)

    @Query("select * from todo_table ORDER BY id ASC")
    fun getAllNoteList():LiveData<List<ToDo>>
}