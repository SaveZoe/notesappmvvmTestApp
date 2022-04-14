package ru.savezoe.notesappmvvm.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.savezoe.notesappmvvm.navigation.NavRoute
import ru.savezoe.notesappmvvm.ui.theme.NotesAppMVVMTheme

@Composable
fun AddScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Add new notes", modifier = Modifier.padding(13.dp)
            )
            OutlinedTextField(value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") })
            OutlinedTextField(value = subtitle,
                onValueChange = { subtitle = it },
                label = { Text(text = "Subtitle") })
            Button(modifier = Modifier.padding(top = 18.dp),
                onClick = { navController.navigate(NavRoute.Main.route) }) {
                Text(text = "Сохранить")
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
        AddScreen(navController = rememberNavController())
    }
}