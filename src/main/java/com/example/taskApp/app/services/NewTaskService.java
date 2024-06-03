package com.example.taskApp.app.services;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;

public interface NewTaskService {
    public Task createTask(NewTaskRequest request);
}
