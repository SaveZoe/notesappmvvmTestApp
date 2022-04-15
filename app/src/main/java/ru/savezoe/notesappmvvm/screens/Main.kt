package ru.savezoe.notesappmvvm.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {

    val notes = viewModel.readAllNotes().observeAsState(listOf()).value

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navController.navigate(NavRoute.Add.route)
            }, backgroundColor = Color(0xFF0080FF)
        ) {
            Icon(
                imageVector = Icons.Filled.Add, contentDescription = "Add note", tint = Color.White
            )
        }
    }) {
        LazyColumn {
            items(notes) { note ->
                NoteItem(note = note, navController = navController)
            }
        }
    }
}


@Composable
fun NoteItem(note: Note, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(15.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route + "/${note.id}")
            }, shape = RoundedCornerShape(10), elevation = 15.dp
    ) {
        Column(
            modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = note.title)
            Text(text = note.subtitle)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevMainScreen() {
    NotesAppMVVMTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

        MainScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}