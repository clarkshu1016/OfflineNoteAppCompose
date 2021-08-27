package com.usfuchsia.offlinenoteappcompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController
import com.usfuchsia.offlinenoteappcompose.R
import com.usfuchsia.offlinenoteappcompose.data.ToDo
import com.usfuchsia.offlinenoteappcompose.data.ToDoViewModel
import com.usfuchsia.offlinenoteappcompose.model.Priority
import com.usfuchsia.offlinenoteappcompose.ui.theme.Purple500
import com.usfuchsia.offlinenoteappcompose.widget.DropDownList

@Composable
fun AddNoteScreen(navController: NavController,viewModel: ToDoViewModel) {
    val scaffoldState = rememberScaffoldState()
    val titleState = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        Modifier.fillMaxSize(), scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Note") },
                backgroundColor = Purple500,
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("noteList") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.insertNote(ToDo(0,"this","hahah"))}) {
                        Icon(painterResource(id = R.drawable.ic_check),null)
                    }
                }
            )
        },

        ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(0.dp, 20.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = titleState.value,
                label={ Text(text = "Title")},
                onValueChange = { titleState.value = it },
                maxLines = 1,
                singleLine = true
            )

            val priorityList = listOf(
                Priority.HIGH.toString(),
                Priority.MEDIUM.toString(),
                Priority.LOW.toString()
            )

            val isOpen = remember { mutableStateOf(true) } // initial value
            val text = remember { mutableStateOf("") } // initial value
            val openCloseOfDropDownList: (Boolean) -> Unit = {
                isOpen.value = it
            }
            val userSelectedString: (String) -> Unit = {
                text.value = it
            }
            DropDownList(
                requestToOpen = isOpen.value,
                list = priorityList,
                openCloseOfDropDownList,
                userSelectedString
            )

            val descriptionState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = descriptionState.value,
                label={ Text(text = "Title")},
                onValueChange = { descriptionState.value = it },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
        }
    }
}