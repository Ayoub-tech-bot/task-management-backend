package com.TaskManager.task.service;

import com.TaskManager.task.domain.CreateTaskRequest;
import com.TaskManager.task.domain.UpdateTaskRequest;
import com.TaskManager.task.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

        Task createTask(CreateTaskRequest request);
        List<Task> findAllTasks();
        Task updateTask(UUID id, UpdateTaskRequest request);
        void deleteTask(UUID id);

}
