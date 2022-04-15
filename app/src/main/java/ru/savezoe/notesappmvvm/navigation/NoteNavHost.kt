package ru.savezoe.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.savezoe.notesappmvvm.MainViewModel
import ru.savezoe.notesappmvvm.screens.*
import ru.savezoe.notesappmvvm.utils.Constants


//Экраны приложения
sealed class NavRoute(val route: String) {
    object Start : NavRoute(Constants.Screens.START_SCREEN)
    object Main : NavRoute(Constants.Screens.MAIN_SCREEN)
    object Add : NavRoute(Constants.Screens.ADD_SCREEN)
    object Note : NavRoute(Constants.Screens.NOTE_SCREEN)
}

//https://developer.android.com/jetpack/compose/navigation
@Composable
fun NoteNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
    }
}