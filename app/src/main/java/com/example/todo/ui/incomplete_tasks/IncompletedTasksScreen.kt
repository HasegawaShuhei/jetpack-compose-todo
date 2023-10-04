package com.example.todo.ui.incomplete_tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun IncompleteTasksScreen(
    viewModel: IncompleteTasksViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(all = 4.dp)
    ) {
        items(
            count = state.tasks.size,
        ) {
            state.tasks[it].let { task ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { viewModel.deleteTask(task = task) })
                ) {
                    Text(text = task.title)
                }
            }
        }
    }
}