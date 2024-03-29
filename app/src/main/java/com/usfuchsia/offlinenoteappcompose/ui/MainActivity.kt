package com.usfuchsia.offlinenoteappcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.usfuchsia.offlinenoteappcompose.data.ToDoViewModel
import com.usfuchsia.offlinenoteappcompose.ui.theme.OfflineNoteAppComposeTheme

class MainActivity : ComponentActivity() {
    private val toDoViewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OfflineNoteAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "noteList") {
                        composable("noteList") { NoteListScreen(navController,toDoViewModel) }
                        composable("addNote") { AddNoteScreen(navController,toDoViewModel) }
                        composable("updateNote") { UpdateNoteScreen(navController) }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OfflineNoteAppComposeTheme {
    }
}