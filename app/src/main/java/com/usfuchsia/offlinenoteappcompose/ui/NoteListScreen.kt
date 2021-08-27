package com.usfuchsia.offlinenoteappcompose.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.usfuchsia.offlinenoteappcompose.R
import com.usfuchsia.offlinenoteappcompose.data.ToDo
import com.usfuchsia.offlinenoteappcompose.data.ToDoViewModel
import com.usfuchsia.offlinenoteappcompose.ui.theme.Purple500

@Composable
fun NoteListScreen(navController: NavController,viewModel: ToDoViewModel) {
    val scaffoldState = rememberScaffoldState()
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        Modifier.fillMaxSize(), scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Note List") },
                backgroundColor = Purple500,
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addNote") },
                elevation = FloatingActionButtonDefaults.elevation(2.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = ""
                )
            }
        },
    ){
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            val allNoteList=viewModel.getAllNoteList()
        }
    }
}