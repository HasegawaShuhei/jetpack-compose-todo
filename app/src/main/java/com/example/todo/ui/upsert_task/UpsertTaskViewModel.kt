package com.example.todo.ui.upsert_task


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpsertTaskViewModel @Inject constructor(
) : ViewModel() {

    private var _state = mutableStateOf(UpsertTaskState())
    val state: State<UpsertTaskState> = _state

    fun onChangeTitle(title: String) {
        _state.value = _state.value.copy(title = title)
    }

    fun onChangeContent(content: String) {
        _state.value = _state.value.copy(content = content)
    }

}