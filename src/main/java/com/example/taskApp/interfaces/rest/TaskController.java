package com.example.taskApp.interfaces.rest;

import com.example.taskApp.app.services.GetTasksService;
import com.example.taskApp.app.services.NewTaskService;
import com.example.taskApp.domain.model.Task;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;
import com.example.taskApp.interfaces.rest.dto.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final NewTaskService newTaskService;
    private final GetTasksService getTasksService;

   public TaskController(NewTaskService newTaskService, GetTasksService getTasksService) {
        this.newTaskService = newTaskService;
        this.getTasksService = getTasksService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody NewTaskRequest request) {
        Task task = newTaskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> tasks = getTasksService.getTasks();
        return ResponseEntity.ok(tasks);
    }
}