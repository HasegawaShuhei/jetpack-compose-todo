package com.example.todo.ui.incomplete_tasks

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.data.Task
import com.example.todo.ui.components.TaskList

@Composable
fun IncompleteTasksScreen(
    viewModel: IncompleteTasksViewModel = hiltViewModel(),
    toUpsertScreen: (Task) -> Unit,
) {
    TaskList(
        tasks = viewModel.state.value.tasks,
        isChecked = false,
        onEdit = toUpsertScreen,
        onDelete = {// TODO
        },
    )
}