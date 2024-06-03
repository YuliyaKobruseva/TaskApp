package com.example.taskApp.util;

import com.example.taskApp.domain.model.Task;
import com.example.taskApp.domain.model.enums.TaskStatus;
import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;

import java.time.LocalDate;
import java.util.Arrays;

public class TestTaskModel {

    public static Task createTask1() {
        Task task = new Task();
        task.setId("1");
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setDueDate(LocalDate.now().plusDays(1));
        task.setTags(Arrays.asList("tag1", "tag2"));
        task.setStatus(TaskStatus.CREATED);
        return task;
    }

    public static Task createTask2() {
        Task task = new Task();
        task.setId("2");
        task.setTitle("Task 2");
        task.setDescription("Description 2");
        task.setDueDate(LocalDate.now().plusDays(2));
        task.setTags(Arrays.asList("tag3", "tag4"));
        task.setStatus(TaskStatus.COMPLETED);
        return task;
    }

    public static Task createExpectedTask(NewTaskRequest request) {
        return Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .tags(request.getTags())
                .status(TaskStatus.CREATED)
                .build();
    }
}