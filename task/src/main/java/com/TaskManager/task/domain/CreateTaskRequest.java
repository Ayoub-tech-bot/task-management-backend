package com.TaskManager.task.domain;

import com.TaskManager.task.domain.entities.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(String title,
                                String description,
                                LocalDate dueDate,
                                TaskPriority priority) {



}
