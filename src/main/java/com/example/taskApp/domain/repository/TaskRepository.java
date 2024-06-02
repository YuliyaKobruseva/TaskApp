package com.example.taskApp.domain.repository;

import com.example.taskApp.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
}
