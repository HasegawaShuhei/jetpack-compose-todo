package com.example.todo.ui.incomplete_tasks

import com.example.todo.data.Task

data class IncompleteTasksState(
    val tasks: List<Task> = emptyList(),
)
