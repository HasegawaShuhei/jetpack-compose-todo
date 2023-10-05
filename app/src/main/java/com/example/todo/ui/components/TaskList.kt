package com.example.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
@Composable
fun TaskListPreview() {
    val tasks = listOf(
        Task(
            id = 0,
            title = "title",
            description = "description"
        ),
        Task(
            id = 1,
            title = "title",
            description = "description"
        ),
        Task(
            id = 2,
            title = "title",
            description = "description"
        )
    )
    TaskList(
        tasks = tasks,
        isChecked = false,
        onEdit = {},
        onDelete = {}
    )
}