package com.example.todo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo.ui.upsert_task.UpsertTaskScreen
import com.example.todo.ui.upsert_task.upsertTaskRoute
import com.example.todo.ui.completed_tasks.CompletedTasksScreen
import com.example.todo.ui.incomplete_tasks.IncompleteTasksScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = TopLevelDestination.INCOMPLETE.route
    ) {
        composable(route = TopLevelDestination.INCOMPLETE.route) {
            IncompleteTasksScreen()
        }
        composable(route = TopLevelDestination.COMPLETED.route) {
            CompletedTasksScreen()
        }
        composable(route = upsertTaskRoute) {
            UpsertTaskScreen(onBack = { navController.popBackStack() })
        }
    }
}