package com.example.taskApp.interfaces.rest;

import com.example.taskApp.app.services.GetTasksService;
import com.example.taskApp.app.services.NewTaskService;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;
import com.example.taskApp.interfaces.rest.dto.TaskResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final NewTaskService newTaskService;
    private final GetTasksService getTasksService;

   public TaskController(NewTaskService newTaskService, GetTasksService getTasksService) {
        this.newTaskService = newTaskService;
        this.getTasksService = getTasksService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Validated @RequestBody NewTaskRequest request) {
        logger.debug("Received request to create task: {}", request);
        Task task = newTaskService.createTask(request);
        logger.info("Task created successfully with id: {}", task.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        logger.debug("Received request to get all tasks");
        List<TaskResponse> tasks = getTasksService.getTasks();
        logger.debug("Returning {} tasks", tasks.size());
        return ResponseEntity.ok(tasks);
    }
}