package ru.savezoe.notesappmvvm.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ru.savezoe.notesappmvvm.MainViewModel
import ru.savezoe.notesappmvvm.MainViewModelFactory
import ru.savezoe.notesappmvvm.navigation.NavRoute
import ru.savezoe.notesappmvvm.ui.theme.NotesAppMVVMTheme
import ru.savezoe.notesappmvvm.utils.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var login by remember { mutableStateOf(Constants.Keys.EMPTY) }
    var password by remember { mutableStateOf(Constants.Keys.EMPTY) }


    ModalBottomSheetLayout(sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Text(
                        text = Constants.Keys.LOG_IN,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(value = login,
                        onValueChange = { login = it },
                        label = { Text(text = Constants.Keys.LOGIN_TEXT) },
                        isError = login.isEmpty()
                    )
                    OutlinedTextField(value = password,
                        onValueChange = { password = it },
                        label = { Text(text = Constants.Keys.PASSWORD_TEXT) },
                        isError = password.isEmpty()
                    )
                    Button(modifier = Modifier.padding(top = 16.dp), onClick = {
                        LOGIN = login
                        PASSWORD = password
                        viewModel.initDatabase(TYPE_FIREBASE) {
                            Log.d("checkData", "Auth success")
                        }
                    },
                    enabled = login.isNotEmpty() && password.isNotEmpty()) {
                        Text(text = Constants.Keys.SIGN_IN)
                    }
                }
            }
        }) {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = Constants.Keys.WHAT_WILL_WE_USE)
                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Button(
                            onClick = {
                                viewModel.initDatabase(TYPE_ROOM) {
                                    navController.navigate(route = NavRoute.Main.route)
                                }
                            }, modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 5.dp)
                        ) {
                            Text(text = Constants.Keys.ROOM_DATABASE)
                        }
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    bottomSheetState.show()
                                }
                            }, modifier = Modifier.fillMaxWidth(1f)
                        ) {
                            Text(text = Constants.Keys.FIREBASE_DATABASE)
                        }
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
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}