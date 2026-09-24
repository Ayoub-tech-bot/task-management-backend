package com.TaskManager.task.domain;

import com.TaskManager.task.domain.entities.TaskPriority;
import com.TaskManager.task.domain.entities.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority

) {
}
