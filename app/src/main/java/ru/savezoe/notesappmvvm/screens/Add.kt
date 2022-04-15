package ru.savezoe.notesappmvvm.screens

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.savezoe.notesappmvvm.MainViewModel
import ru.savezoe.notesappmvvm.MainViewModelFactory
import ru.savezoe.notesappmvvm.model.Note
import ru.savezoe.notesappmvvm.navigation.NavRoute
import ru.savezoe.notesappmvvm.ui.theme.NotesAppMVVMTheme
import ru.savezoe.notesappmvvm.utils.Constants

@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = Constants.Keys.ADD_NEW_NOTE, modifier = Modifier.padding(13.dp)
            )
            OutlinedTextField(value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.NOTE_TITLE) }, isError = title.isEmpty()
            )
            OutlinedTextField(value = subtitle,
                onValueChange = {
                    subtitle = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                },
                label = { Text(text = Constants.Keys.NOTE_SUBTITLE) }, isError = subtitle.isEmpty()
            )
            Button(modifier = Modifier.padding(top = 18.dp), onClick = {
                viewModel.addNote(note = Note(title = title, subtitle = subtitle)) {
                    navController.navigate(NavRoute.Main.route)
                }
            }, enabled = isButtonEnabled) {
                Text(text = Constants.Keys.SAVE)
            }
        }
    }
}

//https://www.youtube.com/watch?v=kCL_d5oYFCQ&list=PLETttyTUYJcWee-e7GA1K0yQnUPlX9voK&index=2
//https://metanit.com/kotlin/jetpack/5.2.php

@Preview(showBackground = true)
@Composable
fun PrevAddScreen() {
    NotesAppMVVMTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

        AddScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}