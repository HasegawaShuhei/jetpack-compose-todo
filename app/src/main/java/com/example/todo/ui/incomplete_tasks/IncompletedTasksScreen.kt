package com.example.todo.ui.incomplete_tasks

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.data.Task
import com.example.todo.ui.components.TaskList

@Composable
fun IncompleteTasksScreen(
    state: IncompleteTasksState,
    onDelete: (Task) -> Unit,
    toUpsertScreen: (Task) -> Unit,
) {
    TaskList(
        tasks = state.tasks,
        isChecked = false,
        onEdit = toUpsertScreen,
        onDelete = onDelete,
    )
}