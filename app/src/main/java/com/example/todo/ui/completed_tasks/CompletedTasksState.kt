package com.example.todo.ui.completed_tasks

import com.example.todo.data.Task

data class CompletedTasksState(
    val tasks: List<Task> = emptyList(),
)
