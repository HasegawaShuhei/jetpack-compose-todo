package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todo.ui.navigation.BottomNavigationBar
import com.example.todo.ui.navigation.NavGraph
import com.example.todo.ui.navigation.TopLevelDestination
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.ui.upsert_task.upsertTaskRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp() {
    TodoTheme {
        val navController = rememberNavController()
        val currentBackStackEntry = navController.currentBackStackEntryAsState().value
        val isActionsVisible = remember(key1 = currentBackStackEntry) {
            currentBackStackEntry?.destination?.route in setOf(
                TopLevelDestination.INCOMPLETE.route,
                TopLevelDestination.COMPLETED.route
            )
        }
        Scaffold(
            bottomBar = {
                if (isActionsVisible) {
                    BottomNavigationBar(navController)
                }
            },
            floatingActionButton = {
                if (isActionsVisible) {
                    FloatingActionButton(onClick = {
                        navController.navigate(route = upsertTaskRoute){

                        }
                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "追加")
                    }
                }
            },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    NavGraph(navController = navController)
                }
            },
        )
    }
}