package com.example.todo.ui.upsert_task


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.Task
import com.example.todo.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpsertTaskViewModel @Inject constructor(
    private val taskDao: TaskDao,
) : ViewModel() {

    private var _state = mutableStateOf(UpsertTaskState())
    val state: State<UpsertTaskState> = _state

    fun setTask(task: Task?) {
        if (task == null) return
        _state.value = _state.value.copy(
            task = task,
            title = task.title,
            description = task.description,
            isEditing = true,
        )
    }

    fun upsertTask() {
        val task = if (_state.value.isEditing) {
            Task(
                id = _state.value.task!!.id,
                title = _state.value.title,
                description = _state.value.description,
                status = _state.value.task!!.status,
            )
        } else {
            Task(
                title = _state.value.title,
                description = _state.value.description
            )
        }

        viewModelScope.launch {
            taskDao.upsert(task)
        }
    }

    fun onTitleChange(title: String) {
        _state.value = _state.value.copy(title = title)
    }

    fun onDescriptionChange(description: String) {
        _state.value = _state.value.copy(description = description)
    }

}