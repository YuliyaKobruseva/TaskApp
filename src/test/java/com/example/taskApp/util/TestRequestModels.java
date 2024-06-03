package com.example.taskApp.util;

import com.example.taskApp.interfaces.rest.dto.NewTaskRequest;

import java.time.LocalDate;
import java.util.Arrays;

public class TestRequestModels {
    public static NewTaskRequest createNewTaskRequest() {
        NewTaskRequest request = new NewTaskRequest();
        request.setTitle("New Task");
        request.setDescription("This is a new task");
        request.setDueDate(LocalDate.now().plusDays(5));
        request.setTags(Arrays.asList("tag1", "tag2"));
        return request;
    }
}
