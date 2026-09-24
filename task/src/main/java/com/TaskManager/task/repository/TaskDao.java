package com.TaskManager.task.repository;

import com.TaskManager.task.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TaskDao extends JpaRepository<Task, UUID> {

}
