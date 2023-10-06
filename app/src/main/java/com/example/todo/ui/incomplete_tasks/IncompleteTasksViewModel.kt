package com.example.todo.ui.incomplete_tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.Status
import com.example.todo.data.Task
import com.example.todo.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncompleteTasksViewModel @Inject constructor(
    private val taskDao: TaskDao,
) : ViewModel() {

    private val _state = mutableStateOf(IncompleteTasksState())
    val state: State<IncompleteTasksState> = _state

    init {
        getIncompleteTasks()
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.delete(task)
        }
    }

    private fun getIncompleteTasks() {
        taskDao.getTasksByStatus(Status.INCOMPLETE).onEach {
            _state.value = _state.value.copy(tasks = it)
        }.launchIn(viewModelScope)
    }
}

