package com.example.todo.ui.upsert_task

data class UpsertTaskState(
    val id: Int? = null,
    val title: String = "",
    val description: String = "",
    val isEditing: Boolean = false,
)