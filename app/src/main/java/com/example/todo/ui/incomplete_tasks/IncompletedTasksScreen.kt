package com.example.todo.ui.incomplete_tasks

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.ui.components.TaskList

@Composable
fun IncompleteTasksScreen(
    viewModel: IncompleteTasksViewModel = hiltViewModel(),
) {
    TaskList(
        tasks = viewModel.state.value.tasks,
        isChecked = false,
        onEdit = { // TODO
        },
        onDelete = {// TODO
        },
    )
}