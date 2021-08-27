package com.usfuchsia.offlinenoteappcompose.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val toDoDao = AppDatabase.buildDatabase(
        application
    ).toDoDao()

    private val repository: ToDoRepository = ToDoRepository(toDoDao)

    fun insertNote(toDo: ToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(toDo)
        }
    }

    fun getAllNoteList(): LiveData<List<ToDo>> {
        lateinit var noteList: LiveData<List<ToDo>>
        viewModelScope.launch {
            noteList = repository.getAllNote()
        }
        return noteList
    }
}