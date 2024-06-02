package com.example.taskApp.app.services;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.model.enums.TaskStatus;
import com.example.taskApp.domain.repository.TaskRepository;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;

import java.time.LocalDate;
import java.util.List;

public interface NewTaskService {
    public Task createTask(NewTaskRequest request);
}
