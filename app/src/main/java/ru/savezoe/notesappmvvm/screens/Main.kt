package ru.savezoe.notesappmvvm.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
fun MainScreen(navController: NavHostController) {
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

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NoteItem(
                title = "Заметка 1",
                subTitle = "Тестовая заметка",
                navController = navController
            )
            NoteItem(
                title = "Заметка 2",
                subTitle = "Тестовая заметка",
                navController = navController
            )
            NoteItem(
                title = "Заметка 3",
                subTitle = "Тестовая заметка",
                navController = navController
            )
            NoteItem(
                title = "Заметка 4",
                subTitle = "Тестовая заметка",
                navController = navController
            )
            NoteItem(
                title = "Заметка 5",
                subTitle = "Тестовая заметка",
                navController = navController
            )
            NoteItem(
                title = "Заметка 6",
                subTitle = "Тестовая заметка",
                navController = navController
            )
        }
    }
}


@Composable
fun NoteItem(title: String, subTitle: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(15.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            }, shape = RoundedCornerShape(10), elevation = 15.dp
    ) {
        Column(
            modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title)
            Text(text = subTitle)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevMainScreen() {
    NotesAppMVVMTheme {
        MainScreen(navController = rememberNavController())
    }
}