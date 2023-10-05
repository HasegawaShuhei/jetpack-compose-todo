package com.example.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.data.Task

@Composable
fun TaskListItem(
    task: Task,
    isChecked: Boolean,
    onEdit: (Task) -> Unit,
    onDelete: (Task) -> Unit,
) {
    var checkState: Boolean by remember { mutableStateOf(isChecked) }
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkState,
                    onCheckedChange = { checkState = it }
                )
                Column {
                    Text(
                        text = task.title,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = task.description)
                }
            }
            Row {
                IconButton(onClick = { onEdit(task) }) {
                    Icon(Icons.Default.Edit, contentDescription = "編集")
                }
                IconButton(onClick = { onDelete(task) }) {
                    Icon(Icons.Default.Delete, contentDescription = "削除")
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskListItemPreview() {
    val task = Task(
        id = 0,
        title = "title",
        description = "description"
    )
    TaskListItem(
        task = task,
        isChecked = false,
        onEdit = {},
        onDelete = {},
    )
}