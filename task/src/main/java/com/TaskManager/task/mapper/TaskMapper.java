package com.TaskManager.task.mapper;

import com.TaskManager.task.domain.CreateTaskRequest;
import com.TaskManager.task.domain.UpdateTaskRequest;
import com.TaskManager.task.domain.dto.UpdateTaskDto;
import com.TaskManager.task.domain.entities.Task;
import com.TaskManager.task.domain.dto.CreateTaskRequestDto;
import com.TaskManager.task.domain.dto.TaskDto;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);
    UpdateTaskRequest fromDto(UpdateTaskDto dto);
    TaskDto toDto(Task task);


}
