package com.example.todo.ui.completed_tasks

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
class CompletedTasksViewModel @Inject constructor(
    private val taskDao: TaskDao,
) : ViewModel() {

    private val _state = mutableStateOf(CompletedTasksState())
    val state: State<CompletedTasksState> = _state

    init {
        getCompleteTasks()
    }

    fun incompleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.upsert(task.copy(status = Status.INCOMPLETE))
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.delete(task)
        }
    }

    private fun getCompleteTasks() {
        taskDao.getTasksByStatus(Status.COMPLETED).onEach {
            _state.value = _state.value.copy(tasks = it)
        }.launchIn(viewModelScope)
    }
}


