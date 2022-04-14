package ru.savezoe.notesappmvvm.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.savezoe.notesappmvvm.navigation.NavRoute
import ru.savezoe.notesappmvvm.ui.theme.NotesAppMVVMTheme

@Composable
fun NoteScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NavRoute.Main.route) },
                backgroundColor = Color(0xFF0080FF)
            ) {
                androidx.compose.material.Icon(
                    imageVector = Icons.Filled.Build,
                    contentDescription = "back"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "title")
            Text(text = "subtitle")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevNoteScreen() {
    NotesAppMVVMTheme {
        NoteScreen(navController = rememberNavController())
    }
}
