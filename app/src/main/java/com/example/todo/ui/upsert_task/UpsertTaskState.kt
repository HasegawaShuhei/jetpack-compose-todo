package com.example.todo.ui.upsert_task

import com.example.todo.data.Task

data class UpsertTaskState(
    val task: Task? = null,
    val title: String = "",
    val description: String = "",
    val isEditing: Boolean = false,
)