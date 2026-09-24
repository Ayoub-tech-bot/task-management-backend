package com.TaskManager.task.service.impl;

import com.TaskManager.task.domain.CreateTaskRequest;
import com.TaskManager.task.domain.UpdateTaskRequest;
import com.TaskManager.task.domain.entities.Task;
import com.TaskManager.task.domain.entities.TaskStatus;
import com.TaskManager.task.exception.TaskNotFoundException;
import com.TaskManager.task.repository.TaskDao;
import com.TaskManager.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }


    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(null, request.title(), request.description(), request.dueDate(), TaskStatus.OPEN,request.priority(), now, now);
        return taskDao.save(task);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskDao.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest request) {
        Task task = taskDao.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setPriority(request.priority());
        task.setStatus(request.status());
        task.setUpdated(Instant.now());
        return taskDao.save(task);
    }

    @Override
    public void deleteTask(UUID id) {
        Task task = taskDao.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        taskDao.delete(task);
    }
}
