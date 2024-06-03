package com.example.taskApp.util;

import com.example.taskApp.interfaces.rest.dto.TaskResponse;

import java.time.LocalDate;
import java.util.Arrays;

public class TestResponseModels {

    public static TaskResponse createTaskResponse1() {
        TaskResponse taskResponse1 = new TaskResponse();
        taskResponse1.setId("1");
        taskResponse1.setTitle("Task 1");
        taskResponse1.setDescription("Description 1");
        taskResponse1.setDueDate(LocalDate.now().plusDays(1));
        taskResponse1.setTags(Arrays.asList("tag1", "tag2"));
        taskResponse1.setStatus("PENDING");
        return taskResponse1;
    }

    public static TaskResponse createTaskResponse2() {

        TaskResponse taskResponse2 = new TaskResponse();
        taskResponse2.setId("2");
        taskResponse2.setTitle("Task 2");
        taskResponse2.setDescription("Description 2");
        taskResponse2.setDueDate(LocalDate.now().plusDays(2));
        taskResponse2.setTags(Arrays.asList("tag3", "tag4"));
        taskResponse2.setStatus("COMPLETED");
        return taskResponse2;
    }
}
