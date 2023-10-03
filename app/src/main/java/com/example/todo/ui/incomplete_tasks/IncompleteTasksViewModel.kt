package com.example.todo.ui.incomplete_tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.Status
import com.example.todo.data.Task
import com.example.todo.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncompleteTasksViewModel @Inject constructor(
    private val taskDao: TaskDao,
) : ViewModel() {

    fun createTask() {
        val task = Task(
            title = "test",
            description = "description",
            status = Status.INCOMPLETE,
        )
        viewModelScope.launch {
            taskDao.insertTask(task)
        }
    }
}