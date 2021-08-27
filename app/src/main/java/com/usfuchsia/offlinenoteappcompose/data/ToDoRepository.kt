package com.usfuchsia.offlinenoteappcompose.data

import androidx.lifecycle.LiveData

class ToDoRepository(private val toDoDao: ToDoDao) {
    suspend fun insertNote(toDo: ToDo) {
        toDoDao.insertNote(toDo)
    }

    suspend fun getAllNote(): LiveData<List<ToDo>> {
        return toDoDao.getAllNoteList()
    }
}