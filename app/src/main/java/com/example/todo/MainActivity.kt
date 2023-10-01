package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.todo.ui.navigation.BottomNavigationBar
import com.example.todo.ui.navigation.NavGraph
import com.example.todo.ui.theme.TodoTheme
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

@Composable
fun TodoApp() {
    TodoTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    NavGraph(navController = navController)
                }
            },
        )
    }
}