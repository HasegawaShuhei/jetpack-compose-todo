package com.example.todo.ui.incomplete_tasks

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun IncompleteTasksScreen(
    viewModel: IncompleteTasksViewModel= hiltViewModel(),
) {
    ElevatedButton(onClick = { viewModel.createTask() }) {
        Text(text = "create")
    }
}