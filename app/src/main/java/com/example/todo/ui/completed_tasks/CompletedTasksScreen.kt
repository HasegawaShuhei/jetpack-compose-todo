package com.example.todo.ui.completed_tasks

import androidx.compose.runtime.Composable
import com.example.todo.data.Task
import com.example.todo.ui.components.TaskList

@Composable
fun CompletedTasksScreen(
    state: CompletedTasksState,
    onIncomplete: (Task) -> Unit,
    onDelete: (Task) -> Unit,
    toUpsertScreen: (Task) -> Unit,
) {
    TaskList(
        tasks = state.tasks,
        isChecked = true,
        onSwitchStatus = onIncomplete,
        onEdit = toUpsertScreen,
        onDelete = onDelete
    )
}

