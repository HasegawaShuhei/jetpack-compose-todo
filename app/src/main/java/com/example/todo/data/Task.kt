package com.example.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val status: Status = Status.INCOMPLETE,
)

enum class Status {
    INCOMPLETE,
    COMPLETED
}

class StatusConverter {

    @TypeConverter
    fun fromStatus(status: Status): String {
        return status.name
    }

    @TypeConverter
    fun toStatus(status: String): Status {
        return Status.valueOf(status)
    }
}

