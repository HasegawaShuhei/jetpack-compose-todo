package com.example.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.data.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    isChecked: Boolean,
    onEdit: (Task) -> Unit,
    onDelete: (Task) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(all = 4.dp)
    ) {
        items(
            count = tasks.size,
        ) {
            TaskListItem(
                task = tasks[it],
                isChecked = isChecked,
                onEdit = onEdit,
                onDelete = onDelete,
            )
        }
    }
}