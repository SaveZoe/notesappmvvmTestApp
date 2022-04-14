package ru.savezoe.notesappmvvm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.savezoe.notesappmvvm.navigation.NavRoute
import ru.savezoe.notesappmvvm.ui.theme.NotesAppMVVMTheme

@Composable
fun StartScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Что будете использовать")
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Button(
                        onClick = {
                            navController.navigate(route = NavRoute.Main.route)
                        }, modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(end = 5.dp)
                    ) {
                        Text(text = "Room database")
                    }
                    Button(
                        onClick = {
                            navController.navigate(route = NavRoute.Main.route)
                        }, modifier = Modifier.fillMaxWidth(1f)
                    ) {
                        Text(text = "Firebase database")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevStartScreen() {
    NotesAppMVVMTheme {
        StartScreen(navController = rememberNavController())
    }
}