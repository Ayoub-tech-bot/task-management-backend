package com.TaskManager.task.domain.dto;

import com.TaskManager.task.domain.entities.TaskPriority;
import com.TaskManager.task.domain.entities.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority

) {
}
