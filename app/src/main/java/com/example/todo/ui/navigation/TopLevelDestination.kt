package com.example.todo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector


enum class TopLevelDestination(
    val route: String,
    val icon: ImageVector,
    val title: String,
) {
    INCOMPLETE(
        route = "incomplete",
        icon = Icons.Default.List,
        title = "未完了",
    ),
    COMPLETED(
        route = "completed",
        icon = Icons.Default.Done,
        title = "完了",
    ),
}