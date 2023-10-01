package com.example.todo.ui.add_task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

const val addTaskRoute = "add_task"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(onBack: () -> Unit) {
    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Button(onClick = { onBack() }) {
                    Text(text = "back")
                }
            }
        },
    )

}