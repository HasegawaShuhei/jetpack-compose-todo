package com.example.todo.ui.upsert_task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

const val upsertTaskRoute = "upsert_task"

@Composable
fun UpsertTaskScreen(
    onBack: () -> Unit,
    viewModel: UpsertTaskViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TextFieldWithTitle(
            modifier = Modifier
                .fillMaxWidth(),
            title = "タイトル",
            value = viewModel.state.value.title,
            onValueChange = viewModel::onChangeTitle,
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldWithTitle(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            title = "内容",
            value = viewModel.state.value.content,
            onValueChange = viewModel::onChangeContent,
            singleLine = false,
            maxLines = 5,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally),
            onClick = {
                // TODO: 追加処理
                onBack()
            }) {
            Text(text = "追加")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    maxLines: Int = 1,
) {
    Column {
        Text(text = title)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            singleLine = singleLine,
            maxLines = maxLines
        )
    }
}

@Preview
@Composable
fun UpsertTaskScreenPreview() {
    UpsertTaskScreen(onBack = {})
}