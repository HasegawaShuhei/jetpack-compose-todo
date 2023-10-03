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

    fun createTask() {
        val task = Task(
            title = _state.value.title,
            content = _state.value.content
        )
        viewModelScope.launch {
            taskDao.insertTask(task)
        }
    }

    fun onChangeTitle(title: String) {
        _state.value = _state.value.copy(title = title)
    }

    fun onChangeContent(content: String) {
        _state.value = _state.value.copy(content = content)
    }

}