package com.TaskManager.task.controller;

import com.TaskManager.task.domain.CreateTaskRequest;
import com.TaskManager.task.domain.UpdateTaskRequest;
import com.TaskManager.task.domain.dto.UpdateTaskDto;
import com.TaskManager.task.domain.entities.Task;
import com.TaskManager.task.domain.dto.CreateTaskRequestDto;
import com.TaskManager.task.domain.dto.TaskDto;
import com.TaskManager.task.mapper.TaskMapper;
import com.TaskManager.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private TaskService taskService;
    private TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto dto = taskMapper.toDto(task);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TaskDto>> findAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        List<TaskDto> dtos = tasks.stream().map(task -> taskMapper.toDto(task)).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskDto updateTaskDto) {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto dto = taskMapper.toDto(task);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
