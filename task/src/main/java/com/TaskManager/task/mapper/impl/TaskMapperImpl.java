package com.TaskManager.task.mapper.impl;

import com.TaskManager.task.domain.CreateTaskRequest;
import com.TaskManager.task.domain.UpdateTaskRequest;
import com.TaskManager.task.domain.dto.UpdateTaskDto;
import com.TaskManager.task.domain.entities.Task;
import com.TaskManager.task.domain.dto.CreateTaskRequestDto;
import com.TaskManager.task.domain.dto.TaskDto;
import com.TaskManager.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {



    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(), dto.description(), dto.dueDate(),dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),dto.status(),
                dto.priority()

        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(),task.getStatus(), task.getPriority()
        );
    }
}
