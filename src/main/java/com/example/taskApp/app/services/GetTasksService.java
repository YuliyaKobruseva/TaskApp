package com.example.taskApp.app.services;

import com.example.taskApp.interfaces.rest.dto.TaskResponse;

import java.util.List;

public interface GetTasksService {

    public List<TaskResponse> getTasks();

}
