package com.example.todo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo.data.Task
import com.example.todo.ui.upsert_task.UpsertTaskScreen
import com.example.todo.ui.upsert_task.upsertTaskRoute
import com.example.todo.ui.completed_tasks.CompletedTasksScreen
import com.example.todo.ui.completed_tasks.CompletedTasksViewModel
import com.example.todo.ui.incomplete_tasks.IncompleteTasksScreen
import com.example.todo.ui.incomplete_tasks.IncompleteTasksViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = TopLevelDestination.INCOMPLETE.route
    ) {
        composable(route = TopLevelDestination.INCOMPLETE.route) {
            val viewModel: IncompleteTasksViewModel = hiltViewModel()
            IncompleteTasksScreen(
                state = viewModel.state.value,
                onComplete = viewModel::completeTask,
                onDelete = viewModel::deleteTask,
                toUpsertScreen = { navigateToUpsertScreen(navController, it) }
            )
        }
        composable(route = TopLevelDestination.COMPLETED.route) {
            val viewModel: CompletedTasksViewModel = hiltViewModel()
            CompletedTasksScreen(
                state = viewModel.state.value,
                onIncomplete = viewModel::incompleteTask,
                onDelete = viewModel::deleteTask,
                toUpsertScreen = { navigateToUpsertScreen(navController, it) }
            )
        }
        composable(route = upsertTaskRoute) {
            val task = navController.previousBackStackEntry?.savedStateHandle?.get<Task?>("task")
            // savedStateHandleに残ってしまうので消しておく
            navController.previousBackStackEntry?.savedStateHandle?.remove<Task?>("task")
            UpsertTaskScreen(onBack = { navController.popBackStack() }, task = task)
        }
    }
}

private fun navigateToUpsertScreen(navController: NavController, task: Task) {
    navController.currentBackStackEntry?.savedStateHandle?.set("task", task)
    navController.navigate(route = upsertTaskRoute)
}